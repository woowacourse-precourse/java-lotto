package lotto.domain.player;

import lotto.domain.util.Validator;

public class PurchaseAmount {
	Validator validator = new Validator();

	private final String purchaseAmount;

	private PurchaseAmount(String amountInput) {
		validator.validateAmount(amountInput);
		this.purchaseAmount = amountInput;
	}

	public long valueOf() {
		return Long.parseLong(purchaseAmount);
	}

	public static PurchaseAmount from(String amountInput){
		return new PurchaseAmount(amountInput);
	}
}
