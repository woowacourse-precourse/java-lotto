package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;

public class BonusNumberException extends CommonException {
    public static void validateNumber(List<Integer> winningNumbers, String bonusNumber) {
        hasCharacters(bonusNumber);
        validateNumberRange(stringToInteger(bonusNumber));
        hasSameNumber(winningNumbers, stringToInteger(bonusNumber));
    }

    public static void hasSameNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.HAS_SAME_NUMBER));
        }
    }
}
