package lotto.user;

import lotto.util.Validator;

public class Quantity {
    private static final int PURCHASE_UNIT = 1_000;

    private final String purchaseAmount;

    public Quantity(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static Quantity generate(String purchaseAmount) {
        return new Quantity(purchaseAmount);
    }

    public static void validate(String purchaseAmount) {
        Validator.validateInteger(purchaseAmount);
        QuantityValidator.validateUnitOfThousand(purchaseAmount);
    }

    public int calculateQuantity() {
        return Integer.parseInt(purchaseAmount) / PURCHASE_UNIT;
    }
}
