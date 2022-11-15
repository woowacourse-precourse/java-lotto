package lotto.domain;

public enum OutputMessage {
    PRINT_LOTTO_QUANTITY("개를 구매했습니다."),
    PRINT_UNIT("개");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}