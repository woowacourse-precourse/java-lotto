package lotto.message;

public enum ErrorMessage {
    INVALID_PURCHASE_PRICE("잘못된 입력 금액입니다."),
    NOT_DIGIT("문자가 아닌 숫자를 입력해주세요.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_PREFIX + this.message;
    }
}
