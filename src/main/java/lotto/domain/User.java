package lotto.domain;

import lotto.utils.Notice;

public class User {
	final int LOTTO_PRICE = 1000;
	private int money;
	private int prizeMoney;
	private String rateOfReturn;

	public User(int money) {
		checkMoney(money);
		this.money = money;
	}
	public int getMoney() {
		return money;
	}

	public String getRateOfReturn() {
		return rateOfReturn;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public void setRateOfReturn(String rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public void setPrizeMoney(int prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	private void checkMoney(int money) {
		if ((money % LOTTO_PRICE) != 0 || money == 0) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + Notice.ERROR_MONEY);
		}
		this.money = (money / LOTTO_PRICE);
	}
}
