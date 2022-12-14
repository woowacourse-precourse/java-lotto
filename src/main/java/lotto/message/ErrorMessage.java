package lotto.message;

public class ErrorMessage {

    public static final String INVALID_NUMERIC_ERROR = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String INVALID_LOTTO_PRICE = "[ERROR] 로또 금액은 1000원 단위로 나누어 떨어져야 합니다.";

    private ErrorMessage() {
    }
}
