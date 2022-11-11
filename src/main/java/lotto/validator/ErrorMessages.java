package lotto.validator;

public class ErrorMessages {
    public static final String INVALID_LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.";
    public static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String INVALID_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다";
    public static final String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 로또 번호는 정수여야 합니다.";
    public static final String INVALID_PAID_MONEY_MESSAGE = "[ERROR] 지불된 금액은 1000원 단위여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 해당 보너스 번호는 이미 당첨 번호에 포함되어 있습니다.";
}
