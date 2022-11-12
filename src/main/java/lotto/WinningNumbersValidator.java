package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator {
    private static int WINNING_NUMBERS_SIZE = 6;
    private static String SIX_NUMBERS_ERROR_MESSAGE = "입력된 값들이 6개가 아닙니다";

    private static boolean isSixNumbers(List<String> winningNumbers) {
        return winningNumbers.size() == WINNING_NUMBERS_SIZE;
    }
    public static void validate(String winningNumberInput) {
        List<String> winningNumbers = Arrays.asList(winningNumberInput.split(","));
        if (!isSixNumbers(winningNumbers)) {
            throw new IllegalArgumentException(SIX_NUMBERS_ERROR_MESSAGE);
        }
    }
}
