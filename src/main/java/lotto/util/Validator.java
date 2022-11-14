package lotto.util;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.GameConstants.*;

public class Validator {

    public static void validateRange(List<Integer> numbers, int length) {
        if (length != numbers.stream()
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

    public static void validateNaturalNumber(String number) {
        if (!Pattern.matches(NATURAL_NUMBER_REGEX, number)) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_EXCEPTION.toString());
        }
    }

    public static void validateLeadingZero(String number) {
        if (!Pattern.matches(NO_LEADING_ZERO_REGEX, number)) {
            throw new IllegalArgumentException(LEADING_ZERO_EXCEPTION.toString());
        }
    }
}
