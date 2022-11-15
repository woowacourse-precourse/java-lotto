package lotto.exception;

public enum ErrorCode {

    ERROR("[ERROR]");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
