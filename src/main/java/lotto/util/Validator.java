package lotto.util;

import java.util.List;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.GameConstants.*;

public class Validator {

    public static void validateRange(List<Integer> numbers) {
        if (LOTTO_NUMBER_LENGTH != numbers.stream()
                .filter(number -> MIN_NUMBER <= number)
                .filter(number -> number <= MAX_NUMBER)
                .count()) {
            throw new IllegalArgumentException(RANGE_EXCEPTION.toString());
        }
    }

    public static void validateLength(List<Integer> numbers, int length) {
        if (numbers.size() != length) {
            throw new IllegalArgumentException(String.format(LENGTH_EXCEPTION.toString(), length));
        }
    }

    public static void validateDuplication(List<Integer> numbers, int length) {
        if (length != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(DUPLICATED_EXCEPTION.toString());
        }
    }
}
