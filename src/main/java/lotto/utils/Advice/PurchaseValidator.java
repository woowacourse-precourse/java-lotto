package lotto.utils.Advice;

import static lotto.domain.model.ErrorMessage.COMMON_MESSAGE;
import static lotto.domain.model.ErrorMessage.PURCHASE_PAY_CONSISTENCE;
import static lotto.domain.model.ErrorMessage.PURCHASE_PAY_REMINDER;
import static lotto.domain.model.ErrorMessage.getErrorMessage;

public abstract class PurchaseValidator {

    public static final int MINIMUM_ORDER = 1000;
    private static final int STANDARD_REMINDER = 0;
    private static final String NUMBER_REG_EXP = "^[0-9]+$";

    public static void checkConsistNumber(String pay) {
        if (!pay.matches(NUMBER_REG_EXP)) {
            throw new IllegalArgumentException(getErrorMessage(PURCHASE_PAY_CONSISTENCE));
        }
    }

    public static void checkReminder(String pay) {
        if (STANDARD_REMINDER != Integer.parseInt(pay) % MINIMUM_ORDER) {
            throw new IllegalArgumentException(getErrorMessage(PURCHASE_PAY_REMINDER));
        }
    }

}
