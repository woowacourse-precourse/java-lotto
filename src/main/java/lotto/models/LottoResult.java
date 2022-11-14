package lotto.models;

import java.util.Map;

import static lotto.constants.Constant.*;

public class LottoResult {
	private int totalEarnedMoney = 0;
	private final Map<Rank, Long> lotteriesResult;

	public LottoResult(Map<Rank, Long> lotteriesResult) {
		this.lotteriesResult = lotteriesResult;
		for (Map.Entry<Rank, Long> rankLongEntry : lotteriesResult.entrySet()) {
			totalEarnedMoney += WINNING_AMOUNTS.get(rankLongEntry.getKey()) * rankLongEntry.getValue();
		}
	}

	public int getRankCount(Rank rank) {
		return Math.toIntExact(lotteriesResult.getOrDefault(rank, NOT_COUNTED));
	}

	public double getEarningRate(int purchaseAmount) {
		double result = (double) totalEarnedMoney / purchaseAmount;
		result = makeUnitByPercent(result);

		return roundAtSecondDecimalPlace(result);
	}

	private double roundAtSecondDecimalPlace(double result) {
		long round = Math.round(result * ROUND_TO_SECOND_DECIMAL_PLACE_FACTOR);

		return (double) round / ROUND_TO_SECOND_DECIMAL_PLACE_FACTOR;
	}

	private double makeUnitByPercent(double result) {
		return result * PERCENT_UNIT_MULTIPLIER;
	}
}
