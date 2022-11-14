package lotto.service;

public class EarningRate {
	public EarningRate() {
	}

	public static double calculate(int paidMoney, Long earningMoney) {
		return (double) earningMoney / paidMoney * 100;
	}
}
