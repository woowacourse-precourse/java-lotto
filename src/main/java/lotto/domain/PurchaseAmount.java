package lotto.domain;

import static lotto.validation.InputAmountValidation.validateInputAmount;
import static lotto.value.MoneyUnit.KRW;

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
        return this.amount / KRW.getPrice();
    }
}
