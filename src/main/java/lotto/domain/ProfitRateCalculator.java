package lotto.domain;

import java.util.Map;

public class ProfitRateCalculator {
	private final double profitRate;

	public ProfitRateCalculator(Map<Rank, Integer> getRanks, int purchaseAmount) {
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

	private int calculatePrizeMoney(Map<Rank, Integer> getRanks) {
		int prizeMoney = 0;

		for (Rank rank : getRanks.keySet()) {
			prizeMoney += rank.getPrizeMoney() * getRanks.get(rank);
		}

		return prizeMoney;
	}
}
