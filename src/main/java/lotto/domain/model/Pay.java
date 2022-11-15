package lotto.domain.model;

import lotto.domain.ErrorMessage;

public class Pay {
	private final long pay;

	public Pay(String pay) {
		this.pay = validateLong(pay);
		validate(this.pay);
	}

	private long validateLong(String input) {
		long money;

		try {
			money = Long.parseLong(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(ErrorMessage.ERROR_NOT_INTEGER.getError_message());
			throw new IllegalArgumentException("정수 값을 입력하세요");
		}
		return money;
	}

	private void validate(long pay) {
		if (pay % 1000 != 0 || pay < 1000) {
			System.out.println(ErrorMessage.ERROR_WRONG_PRICE.getError_message());
			throw new IllegalArgumentException();
		}
	}

	public long getPay() {
		return this.pay;
	}
}
