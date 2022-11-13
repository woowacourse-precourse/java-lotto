package lotto;

public final class ErrorMessage {
    public static final String PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR = "구입 금액은 숫자여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR = "구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    public static final String INVALID_LOTTO_NUMBER_SIZE_ERROR = "로또 번호는 6자리여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR = "로또 번호에 같은 수가 중복으로 존재할 수 없습니다.";

    private ErrorMessage() {
    }
}
