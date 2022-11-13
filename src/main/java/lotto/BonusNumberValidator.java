package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BonusNumberValidator {
    private static String NUMERIC_ERROR_MESSAGE = "숫자를 입력해야 합니다";

    private static boolean isNumeric(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(input.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    public static void validate(String bonusNumberInput) {
        if (!isNumeric(bonusNumberInput)) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
        }
    }
}
