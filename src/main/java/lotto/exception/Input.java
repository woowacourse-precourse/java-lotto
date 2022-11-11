package lotto.exception;

public enum Input {
    NOT_NUMERIC("금액은 숫자여야 합니다."),
    WRONG_UNIT_OF_WON("금액은 1000원 단위여야 합니다.");

    private final String errorMessage;

    Input(String errorMessage) {
        String prefix = "[ERROR] ";
        this.errorMessage = prefix + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
