package lotto;

public enum ErrorMessage {
    INVALID_MONEY_TYPE("숫자만 입력 가능합니다"),
    INVALID_UNIT_OF_MONEY("1000원 단위로만 입력 가능합니다");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return getPrefix() + message;
    }

    private String getPrefix() {
        return "[ERROR] ";
    }
}
