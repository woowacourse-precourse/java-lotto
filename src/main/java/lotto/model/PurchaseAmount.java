package lotto.model;

import lotto.view.Validator;

public class PurchaseAmount {

    private final int purchaseAmount;
    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        validate(purchaseAmount);
    }

    private void validate(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(Validator.ERR_PURCHASE_AMOUNT);
        }
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(Validator.ERR_PURCHASE_AMOUNT);
        }
    }

    public int getNumberOfLottos() {
        return purchaseAmount / Lotto.PRICE;
    }

    public double calculateProfitRate(int winningAmount) {
        return (double) winningAmount / purchaseAmount * 100;
    }
}
