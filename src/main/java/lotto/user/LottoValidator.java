package lotto.user;

import lotto.util.ErrorHandler;
import lotto.util.ErrorMessage;
import lotto.util.Validator;

import java.util.List;

public class LottoValidator extends Validator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBERS_SIZE = 6;

    public static void validateNumbersSize(List<Integer> list) {
        if (list.size() != NUMBERS_SIZE) {
            ErrorHandler.throwException(ErrorMessage.LOTTO_SIZE_EXCEEDED);
        }
    }

    public static void validateNumbersNotRepeated(List<Integer> numbers) {
        if (numbers
                .stream()
                .distinct()
                .count() != numbers.size()) {
            ErrorHandler.throwException(ErrorMessage.LOTTO_NUMBERS_REPEATED);
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        if (numbers
                .stream()
                .anyMatch(number -> (number < START_INCLUSIVE || number > END_INCLUSIVE))) {
            ErrorHandler.throwException(ErrorMessage.LOTTO_NUMBERS_NOT_IN_RANGE);
        }
    }
}
