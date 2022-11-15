package lotto.model;

import java.util.Map;

import lotto.controller.WinStatisticsStatus;

public class YieldCalculator {
	private static final int PERCENTAGE = 100;
	private static final int ROUND_OFF = 10;
	private static final double DIVISION_ROUND_OFF = 10.0;

	private Map<Integer, Integer> matchResult;
	private final int money;
	private int profit = 0;
	private double yield;

	public YieldCalculator(Map<Integer, Integer> matchResult, int money) {
		this.matchResult = matchResult;
		this.money = money;
		calculateProfit();
		calculateYield();
	}

	private void calculateProfit() {
		WinStatisticsStatus[] winStatisticsStatus = WinStatisticsStatus.values();

		for (WinStatisticsStatus rank : winStatisticsStatus) {
			int countTicket = matchResult.get(rank.getRank());
			if (countTicket > 0) {
				profit += countTicket * rank.getPrice();
			}
		}
	}

	private void calculateYield() {
		yield = Math.round(((((double)profit / (double)money) * PERCENTAGE) * ROUND_OFF) / DIVISION_ROUND_OFF);
	}

	public double getYield() {
		return yield;
	}
}
