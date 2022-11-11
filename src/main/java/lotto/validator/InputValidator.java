package lotto.validator;

import static lotto.global.ExceptionConstants.CANNOT_INPUT_ZERO;
import static lotto.global.ExceptionConstants.CAN_ONLY_MULTIPLY_1000;

public class InputValidator extends CommonValidator {

    public static void restEqualZero(long dividend, long divisor) {
        if (dividend % divisor != 0) {
            throw new IllegalArgumentException(CAN_ONLY_MULTIPLY_1000);
        }
    }

    public static void isZero(long number) {
        if (number == 0) {
            throw new IllegalArgumentException(CANNOT_INPUT_ZERO);
        }
    }
}