package lotto.domain;

import java.util.List;

public class ProfitRateCalculator {
	private final double profitRate;

	public ProfitRateCalculator(List<Integer> getRanks, int purchaseAmount) {
		int prizeMoney = calculatePrizeMoney(getRanks);
		this.profitRate = calculateProfitRate(prizeMoney, purchaseAmount);
	}

	public double getProfitRate() {
		return profitRate;
	}

	private double calculateProfitRate(int prizeMoney, int purchaseAmount) {
		double profitRate = (double)prizeMoney / purchaseAmount * 100;
		return Math.round(profitRate * 10) / 10.0;
	}

	private int calculatePrizeMoney(List<Integer> getRanks) {
		int[] prizesByRank = {5000, 50000, 1500000, 30000000, 2000000000};

		int prizeMoney = 0;
		for (int i = 0; i < getRanks.size(); i++) {
			prizeMoney += getRanks.get(i) * prizesByRank[i];
		}
		return prizeMoney;
	}
}
