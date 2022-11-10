package lotto;

import static lotto.ErrorMessage.COMMON_MESSAGE;
import static lotto.ErrorMessage.PURCHASE_PAY_CONSISTENCE;
import static lotto.ErrorMessage.PURCHASE_PAY_REMINDER;

public class InputValidator {

    public static final int MINIMUM_ORDER = 1000;
    public static final int STANDARD_REMINDER = 0;
    public static final String NUMBER_REG_EXP = "^[0-9]+$";

    private InputValidator(){}

    public static void validatePay(String pay) {
        checkConsistNumber(pay);
        checkReminder(pay);
    }

    private static void checkConsistNumber(String pay) {
        if (!pay.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + PURCHASE_PAY_CONSISTENCE.getMessage());
        }
    }

    private static void checkReminder(String pay) {
        if (STANDARD_REMINDER != Integer.parseInt(pay) % MINIMUM_ORDER) {
            throw new IllegalArgumentException(COMMON_MESSAGE.getMessage() + PURCHASE_PAY_REMINDER.getMessage());
        }
    }
}
