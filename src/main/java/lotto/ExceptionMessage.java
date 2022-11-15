package lotto;


public enum ExceptionMessage {

    INVALID_INPUT_VALUE("[ERROR] 잘못된 입력 값입니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
