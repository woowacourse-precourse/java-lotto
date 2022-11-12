package lotto.domain;

import lotto.Notice;

public class User {
	private int money;
	private double rateOfReturn;

	public User(int money) {
		checkMoney(money);

		this.money = money;
	}

	private void checkMoney(int money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "1000원 단위로 입력해 주세요");
		}
		this.money = money / 1000;
	}

	public int getMoney() {
		return money;
	}

	public void setRateOfReturn(double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public double getRateOfReturn() {
		return rateOfReturn;
	}
}
