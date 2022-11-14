package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;

public class CommonException {
    static final String NUMBER = "^[0-9]*$";
    static final int LOTTO_MINIMUM_NUMBER = 1;
    static final int LOTTO_MAXIMUM_NUMBER = 45;

    public static boolean hasCharacters(String number) {
        if (!number.matches(NUMBER)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.CHARACTER_INCLUDED));
        }
        return false;
    }

    public static void validateNumberLength(List<String> numbers, int length) {
        if (numbers.size() != length) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.WRONG_NUMBER_LENGTH));
        }
    }

    public static void validateNumberRange(int number) {
        if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.OUT_OF_NUMBER_RANGE));
        }
    }

    public static int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}
