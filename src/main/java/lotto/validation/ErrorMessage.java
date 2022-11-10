package lotto.validation;

public enum ErrorMessage {
    BLANK_EXCEPTION("[ERROR] 금액을 입력해 주세요."),
    NUMBER_EXCEPTION("[ERROR] 숫자만 입력해 주세요."),
    ZERO_EXCEPTION("[ERROR] 0원을 입력할 수 없습니다. 1,000원 이상 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
