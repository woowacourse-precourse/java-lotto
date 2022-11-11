package lotto.domain;

public class Money {
	private final String ALLOW_NUMBER = "^[0-9]+$";
	private final Character NOT_ALLOWED_NUMBER = '0';
	private final String NOT_NUMBER = "[ERROR] 숫자만 입력이 가능합니다.";
	private final String INVALID_FIRST_DIGIT_ZERO = "[ERROR] 숫자의 첫째자리로 0은 불가능합니다.";
	private final String NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 숫자는 1000이상부터 가능합니다.";
	private final int DEFAULT_UNIT = 1000;

	private int money;

	public Money(String money) {
		validateNumberRange(money);
		validateFirstDigitZero(money);
		validateMultipleOfThousand(money);
		this.money = Integer.parseInt(money);
	}

	private void validateNumberRange(String money) {
		if (!money.matches(ALLOW_NUMBER)) {
			throw new IllegalArgumentException(NOT_NUMBER);
		}
	}

	private void validateFirstDigitZero(String money) {
		if (money.charAt(0) == NOT_ALLOWED_NUMBER) {
			throw new IllegalArgumentException(INVALID_FIRST_DIGIT_ZERO);
		}
	}

	private void validateMultipleOfThousand(String money) {
		int convertMoney = Integer.parseInt(money);
		if (convertMoney % 1000 != 0) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND);
		}
	}

	public int getMoney() {
		return this.money;
	}

	public int getNumberOfPurchases() {
		return this.money / DEFAULT_UNIT;
	}
}
