package lotto.validation;

import java.util.Objects;

import static lotto.constant.ErrorConstant.ERROR_BLANK_INPUT;
import static lotto.constant.ErrorConstant.ERROR_NON_INTEGER;

public class InputValidation {

    public static void isValidInput(String input) {
        if (!checkBlankInput(input)) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
        if (!isDigitInput(input)) {
            throw new IllegalArgumentException(ERROR_NON_INTEGER);
        }
    }
    private static boolean checkBlankInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return false;
        }
        return true;
    }
    private static boolean isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                return false;
        }
        return true;
    }
}
