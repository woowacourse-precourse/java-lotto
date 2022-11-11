package lotto.validator;

import static lotto.constants.LottoConstant.LOTTERY_NUMBER_SEPARATOR;
import static lotto.constants.LottoConstant.VALID_MAX_RANGE;
import static lotto.constants.LottoConstant.VALID_MIN_RANGE;
import static lotto.validator.ErrorMessages.INVALID_RANGE_ERROR_MESSAGE;
import static lotto.validator.ErrorMessages.INVALID_TYPE_ERROR_MESSAGE;

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
}
