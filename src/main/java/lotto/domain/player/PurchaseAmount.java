package lotto.domain.player;

import lotto.domain.Validator;

public class PurchaseAmount {
	Validator validator = new Validator();

	private static String purchaseAmount;

	public PurchaseAmount(String amountInput) {
		validator.validateAmount(amountInput);
		this.purchaseAmount = amountInput;
	}

	public long toConvert() {
		return Long.parseLong(purchaseAmount);
	}
}
