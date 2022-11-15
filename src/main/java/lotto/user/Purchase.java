package lotto.user;

import lotto.util.Constant;
import lotto.util.ErrorHandler;
import lotto.util.ErrorMessage;
import lotto.util.Validator;

public class Purchase {
    private final String purchaseAmount;

    public Purchase(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static Purchase generate(String purchaseAmount) {
        return new Purchase(purchaseAmount);
    }

    public static void validate(String purchaseAmount) {
        Validator.validateInteger(purchaseAmount);
        PurchaseValidator.validateUnitOfThousand(purchaseAmount);
    }

    public int calculateQuantity() {
        return Integer.parseInt(purchaseAmount) / Constant.PURCHASE_UNIT;
    }
}
