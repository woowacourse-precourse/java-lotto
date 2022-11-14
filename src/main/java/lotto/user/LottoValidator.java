package lotto.user;

import lotto.util.Validator;

import java.util.List;

public class LottoValidator extends Validator {
    public static boolean isNumbersNotRepeated(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .count() == numbers.size();
    }

    public static boolean isNumbersInRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        return numbers
                .stream()
                .anyMatch(number -> (number < START_INCLUSIVE || number > END_INCLUSIVE))) {
            ErrorHandler.throwException(ErrorMessage.LOTTO_NUMBERS_NOT_IN_RANGE);
        }
    }
}
