package lotto.model;

import lotto.view.InputValidator;

public class PurchaseAmount {
    private static final int PERCENT_CONVERTER = 100;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        validate(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(InputValidator.ERR_PURCHASE_AMOUNT);
        }
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(InputValidator.ERR_PURCHASE_AMOUNT);
        }
    }

    public int getNumberOfLottos() {
        return purchaseAmount / Lotto.PRICE;
    }

    public double calculateProfitRate(long winningAmount) {
        return (double) winningAmount / purchaseAmount * PERCENT_CONVERTER;
    }
}
