package lotto.domain;

import java.util.Map;

public class ProfitRateCalculator {
	private final double profitRate;

	public ProfitRateCalculator(Map<Rank, Integer> scoreBoard, int purchaseAmount) {
		int prizeMoney = calculatePrizeMoney(scoreBoard);
		this.profitRate = calculateProfitRate(prizeMoney, purchaseAmount);
	}

	public double getProfitRate() {
		return profitRate;
	}

	private int calculatePrizeMoney(Map<Rank, Integer> scoreBoard) {
		int prizeMoney = 0;

		for (Rank rank : scoreBoard.keySet()) {
			prizeMoney += rank.getPrizeMoney() * scoreBoard.get(rank);
		}

		return prizeMoney;
	}

	private double calculateProfitRate(int prizeMoney, int purchaseAmount) {
		return (double)prizeMoney / purchaseAmount * 100;
	}
}
