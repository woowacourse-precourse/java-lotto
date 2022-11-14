package lotto.domain;

import static lotto.common.exception.ErrorMessage.*;

public class Money {
	private static int money;

	public static void from(String moneyString) {
		validateMoney(moneyString);
		setPurchaseAmount(Integer.parseInt(moneyString));
	}

	private static void validateMoney(String moneyString) {
		validateIsNull(moneyString);
		validateIsNumber(moneyString);

		int money = Integer.parseInt(moneyString);

		validateMoneyRange(money);
		validateUnitOfMoney(money);
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
		if (userInput < 1000) {
			throw new IllegalArgumentException(NOT_VALID_MONEY_RANGE);
		}
	}

	private static void validateUnitOfMoney(int money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(NOT_VALID_UNIT_OF_MONEY);
		}
	}
}
