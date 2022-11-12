package lotto.exception;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
