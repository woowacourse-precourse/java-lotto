package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.util.Validator;

public class PurchasingAmount {
	private final int purchasingAmount;
	private final int numberOfTickets;

	public PurchasingAmount(int amount) {
		Validator.validateDivisibility(amount);
		this.purchasingAmount = amount;
		this.numberOfTickets = purchasingAmount / LottoConstant.PRICE_OF_LOTTO;
	}

	public int getPurchasingAmount() {
		return purchasingAmount;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}

}
