package lotto.util;


import java.util.List;

import static lotto.constants.AmountCode.AMOUNTS_UNIT;
import static lotto.constants.ErrorCode.*;

public class ValidUtil {

    public static void validateNumberUnit(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_DIGITS);
        }
    }

    public static String validNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        return input;
    }

    public static void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> subList = numbers.subList(i + 1, numbers.size());
            if (subList.contains(numbers.get(i))) {
                throw new IllegalArgumentException(INVALID_NUMERIC_CONFIGURATION);
            }
        }
    }

    public static int validAmountUnit(int amount) {
        if (amount % AMOUNTS_UNIT != 0) {
            throw new IllegalArgumentException(UNSUITABLE_UNIT);
        }
        return amount;
    }


    public static int validateNumberRange(String number) {
        if (!number.matches("(^[1-3][0-9]$)|(^[1-9]$)|(^4[0-5]$)")) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }

        return Integer.parseInt(number);
    }

    public static String[] validAllWinningNumber(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_DIGITS);
        }
        for (String number : numbers) {
            validateNumberRange(number);
        }
        return numbers;
    }

}
