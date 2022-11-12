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
	private static double totalReward;

	public static void calculateResult() {
		ConsoleOutput.PrintResultMessage(fiveMatchAndBonusMatch, countingMatches);
	}

	public static void calculateProfit(long totalAmount) {
		countPrize();
		ConsoleOutput.PrintProfitMessage(computeProfit(totalAmount));
	}

	public static void findMatch() {
		List<List<Integer>> lottoes = LottoIssuer.issuedLottoes;

		for (List<Integer> lotto : lottoes) {
			getLottoMatch(lotto);
			recordMaxMatch(lottoMatch);
			getBonusMatch(lotto, lottoMatch);
			countMatches(lottoMatch);
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

	private static String computeProfit(long totalAmount){
		return String.format("%.1f", totalReward * 100 / totalAmount);
	}

	private static void countPrize() {
		totalReward += countingMatches[0] * convertToDouble(Rule.valueOf("FIFTH_PRIZE").getReward());
		totalReward += countingMatches[1] * convertToDouble(Rule.valueOf("FOURTH_PRIZE").getReward());
		totalReward += countingMatches[2] * convertToDouble(Rule.valueOf("THIRD_PRIZE").getReward());
		totalReward += fiveMatchAndBonusMatch * convertToDouble(Rule.valueOf("SECOND_PRIZE").getReward());
		totalReward += countingMatches[3] * convertToDouble(Rule.valueOf("FIRST_PRIZE").getReward());
	}

	private static double convertToDouble(String value){
		return Double.parseDouble(value.replaceAll("[^0-9]",""));

	}
}

