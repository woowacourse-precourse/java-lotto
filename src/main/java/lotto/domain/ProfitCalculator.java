package lotto.domain;

import java.util.EnumMap;

import lotto.constant.WinningRating;

public class ProfitCalculator {
	private static final int HUNDRED = 100;

	private float profit;

	public float calculate(PurchasingAmount purchasingAmount, EnumMap<WinningRating, Integer> countsOfWins) {
		countsOfWins.forEach((winningRating, countOfWins) -> profit += winningRating.getPrizeMoney() * countOfWins);
		return (profit / purchasingAmount.getPurchasingAmount()) * HUNDRED;
	}
}
