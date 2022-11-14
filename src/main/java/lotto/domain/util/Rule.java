package lotto.domain.util;

public enum Rule {
	LOTTO_PRICE(1000L),
	LOTTO_FIRST_NUMBER_INCLUSIVE(1),
	LOTTO_LAST_NUMBER_INCLUSIVE(45),
	LOTTO_NUMBER_DIGITS(6),

	FIFTH_PRIZE(3, "5,000원"),
	FOURTH_PRIZE(4, "50,000원"),
	THIRD_PRIZE(5, "1,500,000원"),
	SECOND_PRIZE(5, "30,000,000원"),
	FIRST_PRIZE(6, "2,000,000,000원");

	private int value;
	private long money;

	private String reward;
	private int match;

	Rule(int value) {
		this.value = value;
	}

	Rule(long money) {
		this.money = money;
	}

	Rule(int match, String reward) {
		this.match = match;
		this.reward = reward;
	}

	public int getValue() {
		return value;
	}

	public long getMoney() {
		return money;
	}

	public String getReward() {
		return reward;
	}

	public int getMatch() {
		return match;
	}
}
