package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BonusNumberValidator {
    private static int MIN_BONUS_NUMBER = 1;
    private static int MAX_BONUS_NUMBER = 45;
    private static String NUMERIC_ERROR_MESSAGE = "숫자를 입력해야 합니다";
    private static String RANGE_ERROR_MESSAGE = String.format("%d ~ %d 사이의 숫자들로 입력해야 합니다",
            MIN_BONUS_NUMBER, MAX_BONUS_NUMBER);

    private static boolean isNumeric(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(input.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInValidRange(String input) {
        int number = Integer.parseInt(input);
        return (MIN_BONUS_NUMBER < number && number < MAX_BONUS_NUMBER);
    }

    public static void validate(String bonusNumberInput) {
        if (!isNumeric(bonusNumberInput)) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
        }
        if (!isInValidRange(bonusNumberInput)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
