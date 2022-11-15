package lotto.service;

import static lotto.util.Constants.*;

public class EarningRate {
	public EarningRate() {
	}

	public static double calculate(int paidMoney, Long earningMoney) {
		double earningRate = earningMoney / (double)paidMoney * HUNDRED;
		return roundOff(earningRate);
	}

	private static double roundOff(double earningRate) {
		return Double.parseDouble(String.format(PERCENTAGE_FORMAT, earningRate));
	}
}
