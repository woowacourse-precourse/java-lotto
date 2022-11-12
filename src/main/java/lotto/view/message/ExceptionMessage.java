package lotto.view.message;

public enum ExceptionMessage {
    NON_NUMERIC_VALUE("숫자가 아닌 값을 입력하셨습니다."),
    NON_UNITS_OF_ONE_THOUSAND_WON("1000원 단위가 아닌 가격입니다."),
    NO_MONEY("금액이 0원 입니다.");

    private static final String ERROR_MESSAGE = "[ERROR]";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
