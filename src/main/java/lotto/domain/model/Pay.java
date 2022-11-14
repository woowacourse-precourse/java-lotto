package lotto.domain.model;

import lotto.domain.ErrorMessage;

public class Pay {
	private final Integer pay;

	public Pay(String pay) {
		this.pay = validateInt(pay);
		validate(this.pay);
	}

	int validateInt(String input) {
		int money;

		try {
			money = Integer.parseInt(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(ErrorMessage.ERROR_NOT_INTEGER.getError_message());
			throw new IllegalArgumentException("정수 값을 입력하세요");
		}
		return money;
	}

	private void validate(int pay) {
		if (pay % 1000 != 0 || pay < 1000) {
			System.out.println(ErrorMessage.ERROR_WRONG_PRICE.getError_message());
			throw new IllegalArgumentException();
		}
	}

	public int getPay() {
		return this.pay;
	}
}
