package lotto.user.validation;

public enum ExceptionMessage {
    UNITS("구입 금액은 1000원 단위여야 합니다.");

    private final String message;
    private static final String ERROR = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
