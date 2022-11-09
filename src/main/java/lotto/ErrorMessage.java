package lotto;

public enum ErrorMessage {

    COMMON_MESSAGE("[ERROR] "),
    LOTTE_SIZE_ERROR("Lotto Number Length Is Incorrect. SIZE : ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
