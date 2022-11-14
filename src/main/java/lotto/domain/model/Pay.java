package lotto.domain.model;

import lotto.domain.ErrorMessage;

public class Pay {
	private final Integer pay;

	public Pay(int pay) {
		validate(pay);
		this.pay = pay;
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
