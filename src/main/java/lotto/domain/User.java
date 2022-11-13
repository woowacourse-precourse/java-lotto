package lotto.domain;

import java.util.List;

import lotto.Notice;

public class User {
	private int money;
	private List<Integer> prizeMoney;
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

	public List<Integer> getPrizeMoney() {
		return prizeMoney;
	}

	public void setRateOfReturn(String rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}

	public void setPrizeMoney(List<Integer> prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	private void checkMoney(int money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(Notice.ERROR.getNoticeMessage() + "1000원 단위로 입력해 주세요");
		}
		this.money = money / 1000;
	}
}
