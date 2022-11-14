package lotto.domain;

public class Money extends Number {
	private final String NOT_MULTIPLE_OF_THOUSAND = "[ERROR] 구매금액은 1000의 배수로 입력해 주시기 바랍니다.";
	private final String OVER_MAX_MONEY = "[ERROR] 구매금액은 2,000,000,000이하로 입력해 주시기 바랍니다.";
	private final String UNDER_MIN_MONEY = "[ERROR] 구매금액은 1.000이상으로 입력해 주시기 바랍니다.";
	private final long MAX_MONEY = 2_000_000_000;
	private final long MIN_MONEY = 1_000;
	private final int DEFAULT_UNIT = 1_000;
	private final int REST_ZERO = 0;
	private long money;

	public Money(String money) {
		validateInputLetter(money);
		validateFirstNumberZero(money);
		validateMultipleOfThousand(money);
		validateMoneyBoundary(money);
		this.money = Long.parseLong(money);
	}

	private void validateMultipleOfThousand(String money) {
		long convertedMoney = Long.parseLong(money);
		if (convertedMoney % DEFAULT_UNIT != REST_ZERO) {
			throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND);
		}
	}

	private void validateMoneyBoundary(String money) {
		long convertedMoney = Long.parseLong(money);
		validateOverMaxMoney(convertedMoney);
		validateUnderMinMoney(convertedMoney);
	}

	private void validateOverMaxMoney(long money) {
		if (money > MAX_MONEY) {
			throw new IllegalArgumentException(OVER_MAX_MONEY);
		}
	}

	private void validateUnderMinMoney(long money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(UNDER_MIN_MONEY);
		}
	}

	public long getMoney() {
		return this.money;
	}

	public long getNumberOfPurchases() {
		return this.money / DEFAULT_UNIT;
	}
}
