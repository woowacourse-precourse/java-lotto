package lotto.validator;

import static lotto.constants.LottoConstant.LOTTERY_NUMBER_SEPARATOR;
import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.constants.LottoConstant.VALID_MAX_RANGE;
import static lotto.constants.LottoConstant.VALID_MIN_RANGE;
import static lotto.validator.ErrorMessages.DUPLICATE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_LENGTH_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_RANGE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_TYPE_ERROR_MESSAGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public static void hasValidLotteryNumber(List<Integer> lotteryNumbers) {
        hasValidLength(lotteryNumbers);
        hasNonDuplicateNumbers(lotteryNumbers);
        hasValidRange(lotteryNumbers);
    }

    public static void hasValidBonusNumber(int bonusNumber) {
        hasValidRange(bonusNumber);
    }

    public static void hasValidLength(List<Integer> lotteryNumbers) {
        if (lotteryNumbers.size() != VALID_LOTTERY_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void hasValidType(String number) {
        String tempNumber = number.replaceAll(LOTTERY_NUMBER_SEPARATOR, "");
        if (!tempNumber.matches("-?\\d+")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    public static void hasNonDuplicateNumbers(List<Integer> lotteryNumbers) {
        Set<Integer> tempLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (tempLotteryNumbers.size() != lotteryNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void hasValidRange(List<Integer> lotteryNumbers) {
        if (Collections.max(lotteryNumbers) > VALID_MAX_RANGE || Collections.min(lotteryNumbers) < VALID_MIN_RANGE) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    public static void hasValidRange(int bonusNumber) {
        if (bonusNumber > VALID_MAX_RANGE || bonusNumber < VALID_MIN_RANGE) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }
}
