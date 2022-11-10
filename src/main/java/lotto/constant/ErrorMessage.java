package lotto.constant;

public enum ErrorMessage {

    NOT_CORRECT_SIZE_ERROR("[ERROR] %d개의 숫자를 입력해야 합니다."),
    NOT_NUMERIC_ERROR("[ERROR] 숫자를 입력해야 합니다."),
    NOT_MULTIPLE_ERROR("[ERROR] 구매 금액은 %d원으로 나누어 떨어져야 합니다.");

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
