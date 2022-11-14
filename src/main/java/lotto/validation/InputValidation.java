package lotto.validation;

import java.util.Objects;

public class InputValidation {
    private static final String ERROR_NON_INTEGER = "[ERROR] 숫자만 입력해주세요.";
    private static final String ERROR_BLANK_INPUT = "[ERROR] 값을 입력하지 않았습니다.";

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
