package lotto.domain;

import static lotto.common.exception.ErrorMessage.*;

public class Money {
	private static final int UNIT_OF_MONEY = 1000;
	private static final int MIN_LOTTO_PRICE = 1000;

	private static int money;

	public static void from(String moneyString) {
		int money = validateMoney(moneyString);
		setPurchaseAmount(money);
	}

	private static int validateMoney(String moneyString) {
		validateIsNull(moneyString);
		validateIsNumber(moneyString);

		int money = Integer.parseInt(moneyString);

		validateMoneyRange(money);
		validateUnitOfMoney(money);

		return money;
	}

	private static void setPurchaseAmount(int money) {
		Money.money = money;
	}

	private static void validateIsNull(String moneyString) {
		if (moneyString == null) {
			throw new IllegalArgumentException(NOT_VALID_INPUT_NULL);
		}
	}

	private static void validateIsNumber(String moneyString) {
		try {
			Integer.parseInt(moneyString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_VALID_INPUT_NOT_NUMERIC);
		}
	}

	private static void validateMoneyRange(int userInput) {
		if (userInput < MIN_LOTTO_PRICE) {
			throw new IllegalArgumentException(NOT_VALID_MONEY_RANGE);
		}
	}

	private static void validateUnitOfMoney(int money) {
		if (money % UNIT_OF_MONEY != 0) {
			throw new IllegalArgumentException(NOT_VALID_UNIT_OF_MONEY);
		}
	}

	public static int getPurchaseAmount() {
		return money;
	}
}
