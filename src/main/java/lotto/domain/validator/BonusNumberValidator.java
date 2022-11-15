package lotto.domain.validator;

import lotto.domain.WinningNumbers;

import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.validator.ErrorMessages.RANGE_ERROR_MESSAGE;
import static lotto.domain.validator.ErrorMessages.DUPLICATE_ERROR_MESSAGE;

public class BonusNumberValidator {
    private static boolean isInValidRange(int number) {
        return (MIN_LOTTO_NUMBER.getValue() <= number && number <= MAX_LOTTO_NUMBER.getValue());
    }

    private static boolean isDuplicate(WinningNumbers winningNumbers, int number) {
        return winningNumbers.getNumbers().contains(number);
    }

    public static void validate(WinningNumbers winningNumbers, int number) {
        if (!isInValidRange(number)) {
            String errorMessage = String.format(RANGE_ERROR_MESSAGE.getMessage(),
                    MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
        if (isDuplicate(winningNumbers, number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }
}
