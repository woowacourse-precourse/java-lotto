package lotto.domain.result;

import lotto.domain.util.Rule;

import java.util.HashMap;

import static lotto.domain.result.MatchCalculator.*;

public class TotalRank {
	private static HashMap<Integer, String> totalRank;

	private static final String RESULT_CONTENT = "%d개 일치 (%s) - %d개\n";
	private static final String RESULT_CONTENT_BONUS = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";

	private TotalRank() {
		this.totalRank = summarizeRankResult();
	}

	protected static HashMap<Integer, String> summarizeRankResult() {
		HashMap<Integer, String> rank = new HashMap<>();

		rank.put(5, String.format(RESULT_CONTENT, Rule.FIFTH_PRIZE.getMatch(), Rule.FIFTH_PRIZE.getReward(), countingMatches[0]));
		rank.put(4, String.format(RESULT_CONTENT, Rule.FOURTH_PRIZE.getMatch(), Rule.FOURTH_PRIZE.getReward(), countingMatches[1]));
		rank.put(3, String.format(RESULT_CONTENT, Rule.THIRD_PRIZE.getMatch(), Rule.THIRD_PRIZE.getReward(), countingMatches[2]));
		rank.put(2, String.format(RESULT_CONTENT_BONUS, Rule.SECOND_PRIZE.getMatch(), Rule.SECOND_PRIZE.getReward(), fiveMatchAndBonusMatch));
		rank.put(1, String.format(RESULT_CONTENT, Rule.FIRST_PRIZE.getMatch(), Rule.FIRST_PRIZE.getReward(), countingMatches[3]));

		return rank;
	}

	public static TotalRank publishResultSummary() {
		return new TotalRank();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = totalRank.size(); i >= 1; i--) {
			stringBuilder.append(totalRank.get(i));
		}
		return String.valueOf(stringBuilder).strip();
	}
}
