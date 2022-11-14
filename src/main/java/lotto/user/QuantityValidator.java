package lotto.user;

import lotto.util.ErrorHandler;
import lotto.util.ErrorMessage;
import lotto.util.Validator;

public class QuantityValidator extends Validator {
    private static final int PURCHASE_UNIT = 1_000;

    public static void validateUnitOfThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % PURCHASE_UNIT != 0) {
            ErrorHandler.throwException(ErrorMessage.INVALID_PURCHASE_UNIT);
        }
    }
}
