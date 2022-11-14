package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;

public class WinningNumbersExeption extends CommonException {
    static final int LOTTO_MINIMUM_NUMBER = 1;
    static final int LOTTO_MAXIMUM_NUMBER = 45;
    static final int NUMBER_LENGTH = 6;

    public static void validateWinningNumber(List<String> numbers) {
        validateNumberLength(numbers, NUMBER_LENGTH);
        for (String number : numbers) {
            hasCharacters(number);
            validateNumberRange(stringToInteger(number));
            hasSameNumber(numbers, number);
        }

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

    public static void hasSameNumber(List<String> numbers, String number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.HAS_DUPLICATED_NUMBER));
        }
    }

}
