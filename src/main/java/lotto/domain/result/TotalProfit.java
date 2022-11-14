package lotto.domain.result;

public class TotalProfit {
	private static double totalProfit;

	private TotalProfit(long purchaseAmount) {
		this.totalProfit = computeProfit(purchaseAmount);
	}

	protected static double computeProfit(long purchaseAmount) {
		return RewardCalculator.totalReward * 100 / purchaseAmount;
	}

	public static TotalProfit yieldBy(long purchaseAmount) {
		return new TotalProfit(purchaseAmount);
	}

	public String toString() {
		return String.format("%.1f", totalProfit);
	}
}

