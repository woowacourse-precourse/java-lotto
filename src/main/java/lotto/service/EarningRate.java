package lotto.service;

import static lotto.util.Constants.*;

public class EarningRate {
	public EarningRate() {
	}

	public static double calculate(int paidMoney, Long earningMoney) {
		return (double) earningMoney / paidMoney * PERCENT;
	}
}
