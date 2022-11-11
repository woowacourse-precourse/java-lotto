package lotto.validator;

import static lotto.global.ExceptionConstants.CANNOT_INPUT_ZERO;
import static lotto.global.ExceptionConstants.CAN_ONLY_MULTIPLY_1000;

public class InputValidator extends CommonValidator {

    public static void validatePurchaseInput(String number, long divisor) {
        isAllNumber(number);
        isZero(number);
        restEqualZero(number, divisor);
    }

    public static void validateBounsInput(String number) {
        isAllNumber(number);
        isRangeTrue(Integer.parseInt(number));
    }

    private static void restEqualZero(String dividend, long divisor) {
        if (Long.parseLong(dividend) % divisor != 0) {
            throw new IllegalArgumentException(CAN_ONLY_MULTIPLY_1000);
        }
    }

    private static void isZero(String number) {
        if (Integer.parseInt(number) == 0) {
            throw new IllegalArgumentException(CANNOT_INPUT_ZERO);
        }
    }
}