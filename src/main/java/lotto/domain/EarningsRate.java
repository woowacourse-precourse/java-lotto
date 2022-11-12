package lotto.domain;

public class EarningsRate {
	public static double getEarningsRate(int purchaseAmount, int prizeMoney) {
		return Math.round((double)prizeMoney * 10 / purchaseAmount * 100) / 10;
	}
}
