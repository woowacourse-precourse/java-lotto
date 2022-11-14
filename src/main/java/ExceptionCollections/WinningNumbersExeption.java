package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersExeption extends CommonException {
    static final int NUMBER_LENGTH = 6;

    public static void validateWinningNumber(List<String> numbers) {
        validateNumberLength(numbers, NUMBER_LENGTH);
        for (String number : numbers) {
            hasCharacters(number);
            validateNumberRange(stringToInteger(number));
            hasDuplicatedNumber(numbers, number);
        }
    }

    public static void hasDuplicatedNumber(List<String> numbers, String number) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.HAS_DUPLICATED_NUMBER));
        }
    }
}
