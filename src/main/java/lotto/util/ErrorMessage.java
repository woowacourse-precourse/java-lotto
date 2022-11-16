package lotto.util;

public enum ErrorMessage {
    DUPLICATED_NUMBER("중복된 숫자를 할당할 수 없습니다."),
    NOT_DIVIDED_BY_THOUSAND("1000으로 나누어 떨어지지 않습니다.."),
    NUMBER_OUT_OF_RANGE("1 ~ 45 범위 내의 숫자가 아닙니다."),
    INVALID_FORMAT("올바른 입력형식이 아닙니다.");
    
    private static final String prefix = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + this.message;
    }
}
