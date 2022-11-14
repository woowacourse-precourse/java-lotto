package lotto.domain.model;

import lotto.domain.ui.Printer;

public class Pay {
	private final Integer pay;

	public Pay(int pay) {
		validate(pay);
		this.pay = pay;
	}

	private void validate(int pay) {
		if (pay % 1000 != 0 || pay < 1000) {
			new Printer().printMessage(Message.ERROR);
			throw new IllegalArgumentException();
		}
	}

	public int getPay() {
		return this.pay;
	}
}
