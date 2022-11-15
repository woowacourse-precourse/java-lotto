package lotto.util;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.Error;

public class NumberValidator {

    public static int checkNotInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NOT_INT.getMessage());
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
