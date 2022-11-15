package lotto.domain.model;

import lotto.domain.ErrorMessage;

public class Pay {
	private final long pay;

	public Pay(String pay) {
		this.pay = validateLong(pay);
		validate(this.pay);
	}

	private long validateLong(String input) {
		long money = 0;

		try {
			money = Long.parseLong(input);
		} catch (NumberFormatException exception) {
			new ExceptionHandler(ErrorMessage.ERROR_NOT_INTEGER).tryCatch(ErrorMessage.ERROR_NOT_INTEGER);
		}
		return money;
	}

	private void validate(long pay) {
		if (pay % 1000 != 0 || pay < 1000) {
			new ExceptionHandler(ErrorMessage.ERROR_WRONG_PRICE).tryCatch(ErrorMessage.ERROR_WRONG_PRICE);
		}
	}

	public long getPay() {
		return this.pay;
	}
}
