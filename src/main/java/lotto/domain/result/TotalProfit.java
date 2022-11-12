package lotto.domain.result;

import lotto.Rule;

public class TotalProfit {
	private static double totalReward;

	protected static String computeProfit(long purchaseAmount) {
		return String.format("%.1f", totalReward * 100 / purchaseAmount);
	}

	protected static void countPrize() {
		totalReward += MatchCalculator.countingMatches[0] * convertToDouble(Rule.valueOf("FIFTH_PRIZE").getReward());
		totalReward += MatchCalculator.countingMatches[1] * convertToDouble(Rule.valueOf("FOURTH_PRIZE").getReward());
		totalReward += MatchCalculator.countingMatches[2] * convertToDouble(Rule.valueOf("THIRD_PRIZE").getReward());
		totalReward += MatchCalculator.fiveMatchAndBonusMatch * convertToDouble(Rule.valueOf("SECOND_PRIZE").getReward());
		totalReward += MatchCalculator.countingMatches[3] * convertToDouble(Rule.valueOf("FIRST_PRIZE").getReward());
	}

	private static double convertToDouble(String value) {
		return Double.parseDouble(value.replaceAll("[^0-9]", ""));
	}
}

