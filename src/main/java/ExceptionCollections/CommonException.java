package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;

public class CommonException {
    static final String NUMBER = "^[0-9]*$";
    static final int LOTTO_MINIMUM_NUMBER = 1;
    static final int LOTTO_MAXIMUM_NUMBER = 45;
    static final int LOTTO_NUMBER_LENGTH = 6;

    public static void isEmpty(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.EMPTY_STRING));
        }
    }

    public static void isEmpty(Integer number) {
        isEmpty(number.toString());
    }

    public static boolean hasCharacters(String number) {
        if (!number.matches(NUMBER)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.CHARACTER_INCLUDED));
        }
        return false;
    }

    public static void validateNumberLength(List<? extends Object> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.WRONG_NUMBER_LENGTH));
        }
    }

    public static void validateNumberRange(int number) {
        if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.OUT_OF_NUMBER_RANGE));
        }
    }

    public static void hasDuplicatedNumber(List<? extends Object> numbers, String number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.HAS_DUPLICATED_NUMBER));
        }
    }

    public static void hasDuplicatedNumber(List<? extends Object> numbers, int number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.HAS_DUPLICATED_NUMBER));
        }
    }

    public static int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}
