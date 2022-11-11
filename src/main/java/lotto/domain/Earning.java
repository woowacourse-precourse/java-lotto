package lotto.domain;

public class Earning {
	private final int PERCENTAGE = 100;
	private String earningRate;

	public Earning(int money, long totalCashPrize) {
		this.earningRate = calculateEarningRate(money, totalCashPrize);
	}

	private String calculateEarningRate(int money, long totalCashPrize) {
		double earningRate = ((double) totalCashPrize / money) * PERCENTAGE;
		return String.format("%.1f", earningRate);
	}

	public String getEarningRate() {
		return this.earningRate;
	}
}
