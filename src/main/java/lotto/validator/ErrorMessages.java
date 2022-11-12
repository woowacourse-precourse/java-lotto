package lotto.validator;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.constants.LottoConstant.VALID_LOTTERY_NUMBER_LENGTH;
import static lotto.constants.LottoConstant.VALID_MAX_RANGE;
import static lotto.constants.LottoConstant.VALID_MIN_RANGE;

public class ErrorMessages {
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String INVALID_LENGTH_ERROR_MESSAGE =
            ERROR_MESSAGE_PREFIX + "로또 번호는 " + VALID_LOTTERY_NUMBER_LENGTH + "개의 숫자로 이루어져야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE = ERROR_MESSAGE_PREFIX + "로또 번호는 중복되지 않아야 합니다.";
    public static final String INVALID_RANGE_ERROR_MESSAGE =
            ERROR_MESSAGE_PREFIX + "로또 번호는 " + VALID_MIN_RANGE + "부터 " + VALID_MAX_RANGE + "사이의 숫자여야 합니다";
    public static final String INVALID_TYPE_ERROR_MESSAGE = ERROR_MESSAGE_PREFIX + "로또 번호는 정수여야 합니다.";
    public static final String INVALID_PAID_MONEY_ERROR_MESSAGE =
            ERROR_MESSAGE_PREFIX + "지불된 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE =
            ERROR_MESSAGE_PREFIX + "해당 보너스 번호는 이미 당첨 번호에 포함되어 있습니다.";
}
