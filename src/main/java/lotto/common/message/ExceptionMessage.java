package lotto.common.message;

import java.security.PublicKey;

public class ExceptionMessage {

    /* Exception Error Message StartWith Form */
    public static final String ERROR_CODE = "[ERROR] ";


    /*
    * Exception String Console Out
    * */
    public static final String LOTTO_NUMBERS_OUT_OF_VALUE_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String LOTTO_NUMBERS_SIZE_OUT_OF_RANGE_MESSAGE = "로또 번호는 반드시 6자리 숫자여야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATE_MESSAGE = "로또 번호는 중복되면 안됩니다.";

    public static final String AMOUNT_OF_MONEY_REMAINDER_NOT_ZERO_MESSAGE = "돈은 1000원 단위로 입력해야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATION_MESSAGE = "보너스 숫자는 중복될 수 없습니다.";

    public static final String LOTTO_NUMBER_NOT_IS_DIGIT = "입력한 로또 번호에 숫자가 아닌 문자가 포함되어 있습니다.";
    public static final String GAME_MONEY_TYPE_EXCEPTION_MESSAGE = "입력한 돈에 다른 문자가 포함되어 있습니다.";
}
