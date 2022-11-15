package lotto.utils;

public enum ErrorCode {
    INVALID_SIZE("입력받은 수가 6자리 수가 아닙니다."),
    DUPLICATE_NUMBER("중복되는 숫자가 존재합니다."),
    INVALID_RANGE("가능한 범위는 1 ~ 45 입니다."),
    INVALID_PRICE("적절한 입력 가격이 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
