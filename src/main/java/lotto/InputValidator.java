package lotto;

import static lotto.ErrorMessage.COMMON_MESSAGE;
import static lotto.ErrorMessage.PURCHASE_QTY_CONSISTENCE;
import static lotto.ErrorMessage.PURCHASE_QTY_REMINDER;

public class InputValidator {

    public static final String NUMBER_REG_EXP = "^[0-9]+$";

    private InputValidator(){}

    public static void validateQuantity(String quantity) {
        checkConsistNumber(quantity);
    }

    private static void checkConsistNumber(String quantity) {
        if (!quantity.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + PURCHASE_QTY_CONSISTENCE.getMessage());
        }
    }
}
