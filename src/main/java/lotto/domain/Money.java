package lotto.domain;

public class Money {
	private final String NOT_NUMBER = "[ERROR] 숫자만 입력이 가능합니다.";
	private final String INVALID_FIRST_DIGIT_ZERO = "[ERROR] 숫자의 첫째자리에 0은 불가능합니다.";
	private final String NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 숫자는 1000이상부터 가능합니다.";
	private final String OVER_MAX_NUMBER = "[ERROR] 최대 입력 가능 숫자는 2000000000입니다.";
	private final String ALLOW_NUMBER = "^[0-9]+$";
	private final Character NOT_ALLOWED_NUMBER = '0';
	private final long MAX_NUMBER = 2000000000;
	private final int DEFAULT_UNIT = 1000;
	private long money;

	public Money(String money) {
		validateNumberRange(money);
		validateFirstDigitZero(money);
		validateMultipleOfThousand(money);
		validateOverMaxNumber(money);
		this.money = Long.parseLong(money);
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
		long convertMoney = Long.parseLong(money);
		if (convertMoney % DEFAULT_UNIT != 0) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND);
		}
	}

	private void validateOverMaxNumber(String money) {
		long convertMoney = Long.parseLong(money);
		if (convertMoney > MAX_NUMBER) {
			throw new IllegalArgumentException(OVER_MAX_NUMBER);
		}
	}

	public long getMoney() {
		return this.money;
	}

	public long getNumberOfPurchases() {
		return this.money / DEFAULT_UNIT;
	}
}
