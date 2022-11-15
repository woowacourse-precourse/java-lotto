package lotto.domain;

import static lotto.validation.InputAmountValidation.validateInputAmount;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int inputAmount) {
        validate(inputAmount);
        this.amount = inputAmount;
    }

    private void validate(int inputAmount) {
        validateInputAmount(inputAmount);
    }

    public int quantity() {
        return this.amount / 1000;
    }
}
