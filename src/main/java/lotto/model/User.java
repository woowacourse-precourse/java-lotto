package lotto.model;


import lotto.util.PurchaseAmountValidator;

public class User {
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
    private int purchaseAmount;

    public User(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    private void validate(String purchaseAmount) {
        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
    }


}
