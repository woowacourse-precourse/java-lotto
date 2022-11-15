package lotto.model;

public enum Error {
    INVALID_NUMBER_COUNT("[ERROR] 숫자가 아닌 값을 포함하고 있습니다.");

    Error(String message) {
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
