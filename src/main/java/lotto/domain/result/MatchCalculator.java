package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.player.BonusNumber;
import lotto.domain.player.WinningNumber;

import java.util.HashSet;
import java.util.Set;

public class MatchCalculator {
	protected static int lottoMatch;
	protected static int bonusMatch;
	protected static int fiveMatchAndBonusMatch;
	protected static final int[] countingMatches = new int[4];

	public static void findMatch(WinningNumber winningNumber, BonusNumber bonusNumber, LottoTickets lottoTickets) {
		for (Lotto lotto : lottoTickets.getLottoTickets()) {
			getLottoMatch(lotto, winningNumber);
			getBonusMatch(lotto, lottoMatch, bonusNumber);
			countMatches(lottoMatch);
		}
	}

	private static void getLottoMatch(Lotto lotto, WinningNumber winningNumber) {
		Set<Integer> checkLottoMatch = new HashSet<>(lotto.getNumbers());
		checkLottoMatch.retainAll(winningNumber.toNumbers());
		lottoMatch = checkLottoMatch.size();
	}

	private static void getBonusMatch(Lotto lotto, int lottoMatch, BonusNumber bonusNumber) {
		bonusMatch = 0;
		if ((lotto.getNumbers().contains(bonusNumber.toNumber()))) {
			bonusMatch = 1;
		}
		recordBonusMatch(lottoMatch, bonusMatch);
	}

	private static void recordBonusMatch(int lottoMatch, int bonusMatch) {
		if (lottoMatch == 5 && bonusMatch == 1) {
			fiveMatchAndBonusMatch++;
		}
	}

	private static void countMatches(int match) {
		if (match >= 3) {
			countingMatches[match - 3]++;
		}
	}
}
