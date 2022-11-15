package lotto.message;

public enum ErrorMessage {
    OUT_OF_RANGE("보너스 숫자의 범위가 1 ~ 45 이내가 아닙니다."),
    DUPLICATE("보너스 숫자와 중복이 되는 숫자가 존재합니다."),
    INVALID_LOTTO_NUMBER("입력한 수가 정수 형식이 아닙니다.");

    static final String PREFIX = "[ERROR]";
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s", PREFIX, message);
    }
}
