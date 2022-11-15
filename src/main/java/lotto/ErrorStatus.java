package lotto;

public enum ErrorStatus {
    CASH_DIVDE("돈은 1000원 단위여야합니다.");

    protected final String ERROR_MESSAGE;

    ErrorStatus(String error_message) {
        ERROR_MESSAGE = error_message;
    }
}
