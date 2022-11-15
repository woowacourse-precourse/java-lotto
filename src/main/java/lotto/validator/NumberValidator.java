package lotto.validator;

import static lotto.constants.LottoConstant.VALID_LOTTO_NUMBER_LENGTH;
import static lotto.constants.LottoConstant.VALID_MAX_RANGE;
import static lotto.constants.LottoConstant.VALID_MIN_RANGE;
import static lotto.validator.ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_RANGE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_TYPE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {
    public static void hasValidType(String number) throws IllegalArgumentException {
        if (!number.matches("-?\\d+")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    public static void hasValidRange(int number) throws IllegalArgumentException {
        if (!(number >= VALID_MIN_RANGE && number <= VALID_MAX_RANGE)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    public static void hasNonDuplicateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> tempNumbers = new HashSet<>(numbers);
        if (tempNumbers.size() != numbers.size()) {
            if (numbers.size() == VALID_LOTTO_NUMBER_LENGTH) {
                throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
            }
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
