package lotto.domain;

import lotto.exception.ErrorMessage;

public class Money {

	private final int amount;

	public Money(int amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(int amount) {
		validateNonZero(amount);
		validateDivisible(amount);
	}

	private void validateNonZero(int amount) {
		if (amount == 0) {
			throw new IllegalArgumentException(ErrorMessage.ZERO_MONEY_ERROR.getMessage());
		}
	}

	private void validateDivisible(int amount) {
		if (amount % 1000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_MONEY_ERROR.getMessage());
		}
	}

	public int getAmount() {
		return amount;
	}
}
