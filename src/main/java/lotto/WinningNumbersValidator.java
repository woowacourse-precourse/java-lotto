package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningNumbersValidator {
    private static int WINNING_NUMBERS_SIZE = 6;
    private static int MIN_WINNING_NUMBER = 1;
    private static int MAX_WINNING_NUMBER = 45;
    private static String SIX_NUMBERS_ERROR_MESSAGE = "입력된 값들이 6개가 아닙니다";
    private static String ALL_NUMERIC_ERROR_MESSAGE = "숫자들을 띄어쓰기없이 쉼표로 구분해서 입력해야 합니다";
    private static String RANGE_ERROR_MESSAGE = String.format("%d ~ %d 사이의 숫자들로 입력해야 합니다",
            MIN_WINNING_NUMBER, MAX_WINNING_NUMBER);
    private static String DUPLICATE_ERROR_MESSAGE = "입력한 숫자들 중 중복되는 값이 있습니다";

    private static boolean isSixInputs(List<String> parsedInputs) {
        return parsedInputs.size() == WINNING_NUMBERS_SIZE;
    }

    private static boolean isAllNumeric(List<String> parsedInputs) {
        for (String input : parsedInputs) {
            if (!isNumeric(input)) {
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

    private static boolean isInValidRange(List<String> parsedInputs) {
        for (String input : parsedInputs) {
            int number = Integer.parseInt(input);
            if (number < MIN_WINNING_NUMBER || MAX_WINNING_NUMBER < number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(List<String> parsedInputs) {
        for (String input : parsedInputs) {
            if (Collections.frequency(parsedInputs, input) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void validate(String winningNumberInput) {
        List<String> parsedInputs = Arrays.asList(winningNumberInput.split(","));
        if (!isAllNumeric(parsedInputs)) {
            throw new IllegalArgumentException(ALL_NUMERIC_ERROR_MESSAGE);
        }
        if (!isInValidRange(parsedInputs)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        if (isDuplicate(parsedInputs)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
        if (!isSixInputs(parsedInputs)) {
            throw new IllegalArgumentException(SIX_NUMBERS_ERROR_MESSAGE);
        }
    }
}
