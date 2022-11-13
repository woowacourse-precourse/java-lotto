package lotto.domain;

public enum Error {
    PURCHASE_AMOUNT_IS_ZERO("구매 금액은 0원일 수 없습니다."),
    PURCHASE_AMOUNT_IS_NOT_NUMERIC("구매 금액의 입력 형식이 숫자가 아닙니다."),
    PURCHASE_AMOUNT_IS_NOT_DIVIDE_LOTTERY_PRICE("구매 금액이 로또금액으로 나눠 떨어지지 않습니다."),
    ERROR1(""),
    ERROR2(""),
    ERROR3(""),
    ERROR4(""),
    ERROR213("");

    private final String message;
    private static final String MESSAGE_PREFIX = "[ERROR] ";

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_PREFIX + message;
    }
}
