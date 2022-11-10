package lotto.domain;

import lotto.ExceptionHandler;

public class User {
	private static int money;

	public User(int money) {
		ExceptionHandler.checkMoney(money);

		this.money = money;
	}

	public static int getMoney() {
		return money;
	}
}
