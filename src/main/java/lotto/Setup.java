package lotto;

public enum Setup {

	LOTTO_PRICE(1000L),
	LOTTO_FIRST_NUMBER_INCLUSIVE(1),
	LOTTO_LAST_NUMBER_INCLUSIVE(45),
	LOTTO_NUMBER_DIGITS(6);

	private int value;
	private long money;

	Setup(int value) {
		this.value = value;
	}

	Setup(long money) {
		this.money = money;
	}

	public int getValue() {
		return value;
	}

	public long getMoney() {
		return money;
	}
}
