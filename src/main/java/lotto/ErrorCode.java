package lotto;

public enum ErrorCode {
    INPUT_NOT_NUMBER("[ERROR] 입력값이 숫자가 아닙니다."),
    NOT_UNIQUE_NUMBERS("[ERROR] 중복된 숫자가 존재합니다."),
    INVALID_SIZE("[ERROR] 로또는 번호는 6자리여야 합니다."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    INVALID_MONEY("[ERROR] 구매 금액이 천원 단위가 아닙니다."),
    TOO_SMALl_MONEY("[ERROR] 구매 금액은 천원 이상이어야 합니다."),
    ;

    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
