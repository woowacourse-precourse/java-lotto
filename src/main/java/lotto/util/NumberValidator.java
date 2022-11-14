package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
