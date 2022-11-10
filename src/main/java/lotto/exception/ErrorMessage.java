package lotto.exception;

public enum ErrorMessage {
    NOT_DIGIT("[ERROR] 구매 금액과 로또 번호는 숫자만 입력이 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
