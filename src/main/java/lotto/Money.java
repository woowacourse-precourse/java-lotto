package lotto;

public class Money {
	private int money;
	private int lottoCount;

	public Money(int money) {
		validate(money);
		this.money = money;
		lottoCount = money / 1_000;
	}

	private void validate(int money) {
		if (money % 1_000 != 0) {
			throwException(ErrorMessage.REMAINDER_ERROR);
		}
	}

	private void throwException(ErrorMessage errorType) {
		errorType.printErrorMessage();
		throw new IllegalArgumentException();
	}

	public int getMoney() {
		return money;
	}

	public int getLottoCount() {
		return lottoCount;
	}
}
