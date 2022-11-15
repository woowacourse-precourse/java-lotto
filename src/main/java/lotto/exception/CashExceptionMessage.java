package lotto.exception;

public enum CashExceptionMessage {
    CASH_NOT_MORE_THAN_EXCEPTION("[ERROR] 입력된 값이 0이하여야 합니다."),
    WRONG_CASH_UNIT("[ERROR] 입력값은 1,000원 단위로 나눠져야 합니다.");

    private final String message;

    CashExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
