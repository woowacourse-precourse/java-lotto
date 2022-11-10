package lotto.constant;

public enum ErrorMessage {
    NOT_MULTIPLE_ERROR("[ERROR] 구매 금액은 %s원으로 나누어 떨어져야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int format_number) {
        return String.format(message, format_number);
    }
}
