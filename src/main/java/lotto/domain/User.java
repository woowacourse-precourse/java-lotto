package lotto.domain;

import java.util.List;

import lotto.Notice;

public class User {
	private int LOTTO_PRICE = 1000;
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
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "1000원 단위로 입력해 주세요");
		}
		this.money = (money / LOTTO_PRICE);
	}
}
