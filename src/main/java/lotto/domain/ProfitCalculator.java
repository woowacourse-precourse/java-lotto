package lotto.domain;

import java.util.EnumMap;

import lotto.constant.WinningRating;
import lotto.util.Converter;

public class ProfitCalculator {
	private static final int HUNDRED = 100;

	private float profit;

	public float calculate(PurchasingAmount purchasingAmount, EnumMap<WinningRating, Integer> countsOfWins) {
		countsOfWins.forEach((winningRating, countOfWins) -> profit +=
			Converter.convertStringOfMoneyToLong(winningRating.getPrizeMoney()) * countOfWins);
		return (profit / purchasingAmount.getPurchasingAmount()) * HUNDRED;
	}
}
