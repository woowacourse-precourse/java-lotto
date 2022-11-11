package lotto.validator;

import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.validator.ErrorMessages.DUPLICATE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_LENGTH_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void hasNonDuplicateNumbers(List<Integer> lotteryNumbers) {
        Set<Integer> tempLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (tempLotteryNumbers.size() != lotteryNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}

