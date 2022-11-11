package lotto.user;

import lotto.util.Validator;

public class QuantityValidator extends Validator {
    private static final int PURCHASE_UNIT = 1_000;

    public static boolean isUnitOfThousand(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % PURCHASE_UNIT == 0;
    }
}
