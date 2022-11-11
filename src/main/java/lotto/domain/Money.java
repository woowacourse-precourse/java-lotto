package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.view.OutputView;

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
			OutputView.printError(ErrorMessage.ZERO_MONEY_ERROR);
			throw new IllegalArgumentException();
		}
	}

	private void validateDivisible(int amount) {
		if (amount % 1000 != 0) {
			OutputView.printError(ErrorMessage.NOT_DIVISIBLE_MONEY_ERROR);
			throw new IllegalArgumentException();
		}
	}

	public int getAmount() {
		return amount;
	}
}
