package lotto.domain;

public class ProfitCalculator {
	private static final int HUNDRED = 100;

	public float calculate(int purchasingAmount, int prizeMoney) {
		return (float)prizeMoney / (float)purchasingAmount * HUNDRED;
	}
}
