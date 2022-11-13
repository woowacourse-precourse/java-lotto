package lotto;

public class EarningRate {
	public EarningRate() {
	}

	public static double calculate(int paidMoney, int earningMoney) {
		return (double) earningMoney / paidMoney * 100;
	}
}
