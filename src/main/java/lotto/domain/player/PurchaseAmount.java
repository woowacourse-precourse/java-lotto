package lotto.domain.player;

import lotto.domain.util.Validator;

public class PurchaseAmount {
	private final String purchaseAmount;

	private PurchaseAmount(String amountInput) {
		Validator.validateAmount(amountInput);
		this.purchaseAmount = amountInput;
	}

	public static PurchaseAmount from(String amountInput){
		return new PurchaseAmount(amountInput);
	}

	public long toMoney() {
		return Long.parseLong(purchaseAmount);
	}
}
