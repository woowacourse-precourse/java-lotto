package lotto.domain.result;

import lotto.domain.util.Rule;

public class TotalProfit {
	private static double totalReward;

	protected static String computeProfit(long purchaseAmount) {
		return String.format("%.1f", totalReward * 100 / purchaseAmount);
	}

	protected static void countPrize() {
		totalReward += MatchCalculator.countingMatches[0] * convertToDouble(Rule.FIFTH_PRIZE.getReward());
		totalReward += MatchCalculator.countingMatches[1] * convertToDouble(Rule.FOURTH_PRIZE.getReward());
		totalReward += MatchCalculator.countingMatches[2] * convertToDouble(Rule.THIRD_PRIZE.getReward());
		totalReward += MatchCalculator.fiveMatchAndBonusMatch * convertToDouble(Rule.SECOND_PRIZE.getReward());
		totalReward += MatchCalculator.countingMatches[3] * convertToDouble(Rule.FIRST_PRIZE.getReward());
	}

	private static double convertToDouble(String value) {
		return Double.parseDouble(value.replaceAll("[^0-9]", ""));
	}
}

