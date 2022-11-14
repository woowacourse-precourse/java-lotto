package lotto.util;


import static lotto.constants.AmountCode.AMOUNTS_UNIT;
import static lotto.constants.ErrorCode.NOT_NUMBER;
import static lotto.constants.ErrorCode.UNSUITABLE_UNIT;

public class ValidUtil {

    public static String validInputAmounts(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        return input;
    }

    public static int validAmountUnit(int amount) {
        if (amount % AMOUNTS_UNIT != 0) {
            throw new IllegalArgumentException(UNSUITABLE_UNIT);
        }
        return amount;
    }

}
