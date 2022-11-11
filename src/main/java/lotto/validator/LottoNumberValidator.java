package lotto.validator;

import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.validator.ErrorMessages.INVALID_LENGTH_ERROR_MESSAGE;

import java.util.List;

public class LottoNumberValidator extends NumberValidator {
    public static void hasValidLotteryNumber(List<Integer> lotteryNumbers) {
        hasValidLength(lotteryNumbers);
        hasNonDuplicateNumbers(lotteryNumbers);
        lotteryNumbers.forEach(NumberValidator::hasValidRange);
    }

    public static void hasValidLength(List<Integer> lotteryNumbers) {
        if (lotteryNumbers.size() != VALID_LOTTERY_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }
}

