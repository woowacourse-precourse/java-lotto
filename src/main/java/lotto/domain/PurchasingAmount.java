package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.util.Validator;

public class PurchasingAmount {
	private final int numberOfTickets;

	public PurchasingAmount(int amount) {
		Validator.validateDivisibility(amount);
		this.numberOfTickets = amount / LottoConstant.PRICE_OF_LOTTO;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

}
