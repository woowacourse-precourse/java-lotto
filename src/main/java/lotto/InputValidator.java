package lotto;

import static lotto.ErrorMessage.COMMON_MESSAGE;
import static lotto.ErrorMessage.PURCHASE_QTY_CONSISTENCE;
import static lotto.ErrorMessage.PURCHASE_QTY_REMINDER;

public class InputValidator {

    public static final int MINIMUM_ORDER = 1000;
    public static final int STANDARD_REMINDER = 0;
    public static final String NUMBER_REG_EXP = "^[0-9]+$";

    private InputValidator(){}

    public static void validateQuantity(String quantity) {
        checkConsistNumber(quantity);
        checkReminder(quantity);
    }

    private static void checkConsistNumber(String quantity) {
        if (!quantity.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + PURCHASE_QTY_CONSISTENCE.getMessage());
        }
    }

    private static void checkReminder(String quantity) {
        if (STANDARD_REMINDER != Integer.parseInt(quantity) % MINIMUM_ORDER) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + PURCHASE_QTY_REMINDER.getMessage());
        }
    }
}
