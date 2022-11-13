package lotto.validator;

import java.util.HashSet;
import java.util.List;

import static lotto.validator.ExceptionStatus.*;

public class LottoValidator {

    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validate(List<Integer> numbers) {
        validateExactSize(numbers);
        validateLottoNumberOverlap(numbers);
        validateCorrectRange(numbers);
    }

    public static void validateCorrectRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    private static void validateCorrectRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateCorrectRange);
    }

    private static void validateExactSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NO_OVER_SIX_NUMBERS.getMessage());
        }
    }

    private static void validateLottoNumberOverlap(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER.getMessage());
        }
    }
}
