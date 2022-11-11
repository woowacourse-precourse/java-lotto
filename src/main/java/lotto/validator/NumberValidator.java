package lotto.validator;

import static lotto.constants.LottoConstant.LOTTERY_NUMBER_SEPARATOR;
import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
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
    public static void hasValidType(String number) {
        String tempNumber = number.replaceAll(LOTTERY_NUMBER_SEPARATOR, "");
        if (!tempNumber.matches("-?\\d+")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    public static void hasValidRange(int lotteryNumber) {
        if (!(lotteryNumber >= VALID_MIN_RANGE && lotteryNumber <= VALID_MAX_RANGE)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }

    public static void hasNonDuplicateNumbers(List<Integer> lotteryNumbers) {
        Set<Integer> tempLotteryNumbers = new HashSet<>(lotteryNumbers);
        if (tempLotteryNumbers.size() != lotteryNumbers.size()) {
            if (lotteryNumbers.size() == VALID_LOTTERY_NUMBER_LENGTH) {
                throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE);
            }
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
