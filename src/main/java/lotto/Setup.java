package lotto;

public enum Setup {

	LOTTO_PRICE(1000),
	LOTTO_FIRST_NUMBER_INCLUSIVE(1),
	LOTTO_LAST_NUMBER_INCLUSIVE(45),
	LOTTO_NUMBER_DIGITS(6);

	private final int value;

	Setup(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
