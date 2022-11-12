package lotto.domain;

import java.util.List;

public class User {
	private static int money;
	private double rateOfReturn;

	public User(int money) {
		checkMoney(money);

		this.money = money;
	}

	private void checkMoney(int money) {
		try {
			money /= 1000;
		} catch (Exception e) {
			System.out.println("[ERROR]");
		}
		this.money = money;
	}

	public static int getMoney() {
		return money;
	}

	public void setRateOfReturn(double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public double getRateOfReturn() {
		return rateOfReturn;
	}
}
