package lotto;

public enum ErrorMessage {
    ILLEGAL_ARGUMENT_ERROR_MESSAGE("[ERROR] Illegal Argument");

    private final String  message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
