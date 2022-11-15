package lotto.util;

import lotto.constant.ExceptionConstants;
import lotto.constant.GameConstants;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public static void validateRange(List<Integer> numbers, int length) {
        if (length != numbers.stream()
                .filter(number -> GameConstants.MIN_NUMBER <= number)
                .filter(number -> number <= GameConstants.MAX_NUMBER)
                .count()) {
            throw new IllegalArgumentException(ExceptionConstants.WRONG_RANGE.toString());
        }
    }

    public static void validateRange(int number) {
        if (number < GameConstants.MIN_NUMBER || GameConstants.MAX_NUMBER < number) {
            throw new IllegalArgumentException(ExceptionConstants.WRONG_RANGE.toString());
        }
    }

    public static void validateLength(List<Integer> numbers, int length) {
        if (numbers.size() != length) {
            throw new IllegalArgumentException(String.format(ExceptionConstants.WRONG_LENGTH.toString(), length));
        }
    }

    public static void validateDuplication(List<Integer> numbers, int length) {
        if (length != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException(ExceptionConstants.DUPLICATION.toString());
        }
    }

    public static void validateNaturalNumber(String number) {
        if (!Pattern.matches(GameConstants.NATURAL_NUMBER_REGEX, number)) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_NATURAL_NUMBER.toString());
        }
    }

    public static void validateLeadingZero(String number) {
        if (!Pattern.matches(GameConstants.NO_LEADING_ZERO_REGEX, number)) {
            throw new IllegalArgumentException(ExceptionConstants.LEADING_ZERO.toString());
        }
    }
}
