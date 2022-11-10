package lotto.domain;

import lotto.exception.ErrorMessage;

public class Money {

	private final int amount;

	public Money(String amount) {
		validate(amount);
		this.amount = Integer.parseInt(amount);
	}

	private void validate(String amount) {
		validateNumber(amount);
		validateNonZero(Integer.parseInt(amount));
		validateDivisible(Integer.parseInt(amount));
	}

	private void validateNumber(String amount) {
		final String REGEX = "[0-9]+";

		if (!amount.matches(REGEX)) {
			System.out.println(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
			throw new IllegalArgumentException();
		}
	}

	private void validateNonZero(int amount) {
		if (amount == 0) {
			System.out.println(ErrorMessage.ZERO_MONEY_ERROR.getMessage());
			throw new IllegalArgumentException();
		}
	}

	private void validateDivisible(int amount) {
		if (amount % 1000 != 0) {
			System.out.println(ErrorMessage.NOT_DIVISIBLE_MONEY_ERROR.getMessage());
			throw new IllegalArgumentException();
		}
	}

	public int getAmount() {
		return amount;
	}
}
