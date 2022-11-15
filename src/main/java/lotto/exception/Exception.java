package lotto.exception;

import static lotto.constant.MessageConstants.*;
import static lotto.constant.Constants.*;

public class Exception {
    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throwException(WRONG_FORMAT_MESSAGE);
        }
    }

    public static void validateDivision(String purchaseCost) {
        if(Integer.parseInt(purchaseCost) % LOTTO_COST != ZERO) {
            throwException(WRONG_PURCHASE_COST_MESSAGE);
        }
    }

    public static void throwException(String message) {
        throw new IllegalArgumentException(ERROR + message);
    }
}
