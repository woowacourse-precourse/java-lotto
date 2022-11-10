package lotto.validation;

public enum ErrorMessage {
    BLANK_EXCEPTION("[ERROR] 금액을 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
