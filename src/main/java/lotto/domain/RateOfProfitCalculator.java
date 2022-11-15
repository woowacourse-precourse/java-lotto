package lotto.domain;

public class RateOfProfitCalculator {
	private static final int HUNDRED = 100;

	public float calculate(int purchasingAmount, long prizeMoney) {
		return (float)prizeMoney / (float)purchasingAmount * HUNDRED;
	}
}
