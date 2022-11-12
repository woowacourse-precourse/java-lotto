package lotto.domain.result;

import lotto.LottoIssuer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchCalculator {

	private static int lottoMatch;
	private static int bonusMatch;
	protected static int fiveMatchAndBonusMatch;
	protected static final int[] countingMatches = new int[4];

	public static void findMatch(List<Integer> winningNumber, int bonusNumber) {
		List<List<Integer>> issuedLottoes = LottoIssuer.issuedLottoes;

		for (List<Integer> lotto : issuedLottoes) {
			getLottoMatch(lotto, winningNumber);
			getBonusMatch(lotto, lottoMatch, bonusNumber);
			countMatches(lottoMatch);
		}
	}

	private static void getLottoMatch(List<Integer> lotto, List<Integer> winningNumber) {
		Set<Integer> checkLottoMatch = new HashSet<>(lotto);
		checkLottoMatch.retainAll(winningNumber);
		lottoMatch = checkLottoMatch.size();
	}

	private static void getBonusMatch(List<Integer> lotto, int lottoMatch, int bonusNumber) {
		bonusMatch = 0;
		if (lotto.contains(bonusNumber)) {
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
