package lotto;

import lotto.domain.Player;
import lotto.ui.ConsoleOutput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculation {

	private static int maxLottoMatch;
	private static int fiveMatchAndBonusMatch;
	private static final int[] countingMatches = new int[4];
	private static int lottoMatch;
	private static int bonusMatch;

	public static void yieldResult(long totalAmount) {
		ConsoleOutput.PrintResultMessage(fiveMatchAndBonusMatch, countingMatches);
	}

	public static void findMatch() {
		List<List<Integer>> lottoes = LottoIssuer.issuedLottoes;

		for (List<Integer> lotto : lottoes) {
			getLottoMatch(lotto);
			recordMaxMatch(lottoMatch);
			countMatches(lottoMatch);
			getBonusMatch(lotto, lottoMatch);
		}
	}

	private static void getBonusMatch(List<Integer> lotto, int lottoMatch) {
		Set<Integer> checkBonusMatch = new HashSet<>(lotto);
		checkBonusMatch.retainAll(Player.winningNumbers);
		bonusMatch = checkBonusMatch.size();
		recordBonusMatch(lottoMatch, bonusMatch);
	}

	private static void getLottoMatch(List<Integer> lotto) {
		Set<Integer> checkLottoMatch = new HashSet<>(lotto);
		checkLottoMatch.retainAll(Player.winningNumbers);
		lottoMatch = checkLottoMatch.size();
	}


	private static void recordMaxMatch(int match) {
		if (match > maxLottoMatch) {
			maxLottoMatch = match;
		}
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

