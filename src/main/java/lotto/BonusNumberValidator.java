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
    private static String DUPLICATE_ERROR_MESSAGE = "당첨번호들 중 중복되는 값이 있습니다";

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
        return (MIN_BONUS_NUMBER <= number && number <= MAX_BONUS_NUMBER);
    }

    private static boolean isDuplicate(String input, WinningNumbers winningNumbers) {
        int number = Integer.parseInt(input);
        return winningNumbers.getNumbers().contains(number);
    }

    public static void validate(String bonusNumberInput, WinningNumbers winningNumbers) {
        if (!isNumeric(bonusNumberInput)) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
        }
        if (!isInValidRange(bonusNumberInput)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        if (isDuplicate(bonusNumberInput, winningNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
