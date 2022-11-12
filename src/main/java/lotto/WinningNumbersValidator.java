package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator {
    private static int WINNING_NUMBERS_SIZE = 6;
    private static String SIX_NUMBERS_ERROR_MESSAGE = "입력된 값들이 6개가 아닙니다";
    private static String ALL_NUMERIC_ERROR_MESSAGE = "숫자들을 띄어쓰기없이 쉼표로 구분해서 입력해야 합니다";

    private static boolean isSixNumbers(List<String> winningNumbers) {
        return winningNumbers.size() == WINNING_NUMBERS_SIZE;
    }

    private static boolean isAllNumeric(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            if (!isNumeric(number)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumeric(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(input.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    public static void validate(String winningNumberInput) {
        List<String> winningNumbers = Arrays.asList(winningNumberInput.split(","));
        if (!isAllNumeric(winningNumbers)) {
            throw new IllegalArgumentException(ALL_NUMERIC_ERROR_MESSAGE);
        }
        if (!isSixNumbers(winningNumbers)) {
            throw new IllegalArgumentException(SIX_NUMBERS_ERROR_MESSAGE);
        }
    }
}
