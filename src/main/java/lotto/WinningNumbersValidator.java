package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator {
    private static int WINNING_NUMBERS_SIZE = 6;
    private static int MIN_WINNING_NUMBER = 1;
    private static int MAX_WINNING_NUMBER = 45;
    private static String SIX_NUMBERS_ERROR_MESSAGE = "입력된 값들이 6개가 아닙니다";
    private static String ALL_NUMERIC_ERROR_MESSAGE = "숫자들을 띄어쓰기없이 쉼표로 구분해서 입력해야 합니다";
    private static String RANGE_ERROR_MESSAGE = String.format("%d ~ %d 사이의 숫자들로 입력해야 합니다",
            MIN_WINNING_NUMBER, MAX_WINNING_NUMBER);

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

    private static boolean isInValidRange(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            int num = Integer.parseInt(number);
            if (num < MIN_WINNING_NUMBER || MAX_WINNING_NUMBER < num) {
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
        if (!isInValidRange(winningNumbers)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        if (!isSixNumbers(winningNumbers)) {
            throw new IllegalArgumentException(SIX_NUMBERS_ERROR_MESSAGE);
        }
    }
}
