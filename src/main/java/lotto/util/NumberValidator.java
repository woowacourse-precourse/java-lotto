package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.Error;

public class NumberValidator {

    public static int checkNotInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_INT.getMessage());
        }
    }

    public static String checkNotComma(String input) {
        if (input.split(",").length != 6) {
            throw new IllegalArgumentException(Error.NOT_COMMA.getMessage());
        }
        return input;
    }

    public static List<Integer> checkNumbersNotInt(String input) {
        try {
            return Arrays.stream(input.split(",")).mapToInt(Integer::valueOf).boxed().collect(
                    Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NOT_INT.getMessage());
        }
    }

    public static void checkWrongLottoAmount(int amount, int lottoPrice) {
        if (amount % lottoPrice != 0) {
            throw new IllegalArgumentException(Error.WRONG_LOTTO_AMOUNT.getMessage());
        }
    }

    public static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.OVER_SIZE.getMessage());
        }
    }

    public static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.NOT_DUPLICATE.getMessage());
        }
    }

    public static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.WRONG_RANGE.getMessage());
        }
    }
}
