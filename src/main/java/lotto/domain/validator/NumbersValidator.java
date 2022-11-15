package lotto.domain.validator;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConstants.LOTTO_SIZE;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.validator.ErrorMessages.RANGE_ERROR_MESSAGE;
import static lotto.domain.validator.ErrorMessages.DUPLICATE_ERROR_MESSAGE;
import static lotto.domain.validator.ErrorMessages.SIZE_ERROR_MESSAGE;

public class NumbersValidator {
    private static boolean isLottoSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE.getValue();
    }

    private static boolean isInValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void validate(List<Integer> numbers) {
        if (!isLottoSize(numbers)) {
            String errorMessage = String.format(SIZE_ERROR_MESSAGE.getMessage(), LOTTO_SIZE.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
        if (!isInValidRange(numbers)) {
            String errorMessage = String.format(RANGE_ERROR_MESSAGE.getMessage(),
                    MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }
}
