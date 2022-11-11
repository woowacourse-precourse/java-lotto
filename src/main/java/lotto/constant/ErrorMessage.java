package lotto.constant;

public enum ErrorMessage {

    NOT_CORRECT_SIZE_ERROR("[ERROR] %d개의 숫자를 입력해야 합니다."),
    CONTAINS_DUPLICATE_ERROR("[ERROR] 중복되지 않는 숫자를 입력해야 합니다."),
    NOT_NUMERIC_ERROR("[ERROR] 숫자를 입력해야 합니다."),
    NOT_MULTIPLE_ERROR("[ERROR] 구매 금액은 %d원으로 나누어 떨어져야 합니다."),
    NOT_IN_RANGE_ERROR("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int formatNumber) {
        return String.format(message, formatNumber);
    }
    public String getMessage(int start, int end) {
        return String.format(message, start, end);
    }
}
