package lotto.message;

public class ErrorMessage {
    private ErrorMessage() {}

    public static String PURCHASE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 숫자여야 합니다.";
    public static String PURCHASE_THOUSAND_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    public static String PURCHASE_EMPTY_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 빈 값을 입력할 수 없습니다.";
    public static String LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자로만 입력해야 합니다.";
    public static String LOTTO_NUMBER_EMPTY_ERROR_MESSAGE = "[ERROR] 로또 번호는 빈 값을 입력할 수 없습니다.";
    public static String LOTTO_NUMBER_QUOTE_ERROR_MESSAGE = "[ERROR] 로또 번호가 범위와 맞지 않을 위험이 있습니다. 다시 시도해주세요.";
    public static String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static String LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static String LOTTO_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개만 입력해야 합니다.";
    public static String BONUS_NUMBER_OVERLAP_ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.";

}
