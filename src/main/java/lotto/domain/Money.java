package lotto.domain;

public class Money {
	private final String NOT_NUMBER = "[ERROR] 구매금액은 숫자만 입력해 주시기 바랍니다.";
	private final String INVALID_FIRST_DIGIT_ZERO = "[ERROR] 구매금액의 첫째자리는 1이상으로 입력해 주시기 바랍니다.";
	private final String NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 구매금액은 1000의 배수로 입력해 주시기 바랍니다.";
	private final String OVER_MAX_NUMBER = "[ERROR] 구매금액은 2,000,000,000이하로 입력해 주시기 바랍니다.";
	private final String ALLOW_NUMBER = "^[0-9]+$";
	private final Character NOT_ALLOWED_NUMBER = '0';
	private final long MAX_NUMBER = 2_000_000_000;
	private final int DEFAULT_UNIT = 1_000;
	private final int REST_ZERO = 0;
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
		long convertedMoney = Long.parseLong(money);
		if (convertedMoney % DEFAULT_UNIT != REST_ZERO) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND);
		}
	}

	private void validateOverMaxNumber(String money) {
		long convertedMoney = Long.parseLong(money);
		if (convertedMoney > MAX_NUMBER) {
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
