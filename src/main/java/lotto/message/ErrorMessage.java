package lotto.message;

public class ErrorMessage {

    public static final String INVALID_NUMERIC_ERROR = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String INVALID_LOTTO_PRICE = "[ERROR] 로또 금액은 1000원 단위로 나누어 떨어져야 합니다.";
    public static final String DUPLICATED_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되면 안됩니다.";
    public static final String INVALID_LOTTO_COUNT = "[ERROR] 로또는 6개의 숫자로 구성되어야 합니다.";
    public static final String OUT_OF_BOUNDS_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 1 ~ 45의 숫자로 구성돼야 합니다.";
    public static final String INVALID_WINNING_NUMBER = "[ERROR] 잘못된 형식의 당첨번호 입력입니다. 1,2,3,4,5,6과 같은 형식으로 입력해야 합니다.";

    private ErrorMessage() {
    }
}
