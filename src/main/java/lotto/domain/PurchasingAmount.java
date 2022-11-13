package lotto.domain;

import lotto.util.Validator;

public class PurchasingAmount {
	private final int amount;
	public PurchasingAmount(int amount) {
		Validator.validateDivisibility(amount);
		this.amount = amount;
	}


}
