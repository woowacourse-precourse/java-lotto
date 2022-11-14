package lotto.resource.message;

import lotto.resource.Constant;

public enum ExceptionMessage {
    NON_NUMERIC_VALUE("숫자가 아닌 값을 입력하셨습니다."),
    NON_UNITS_OF_ONE_THOUSAND_WON(Constant.PRICE_PER_LOTTO.getValue() + "원 단위가 아닌 금액입니다."),
    NO_MONEY("금액이 0원 입니다."),
    APPLICATION_EXIT("에러로 인해 시스템을 종료합니다."),
    INVALID_NUMBER("번호의 범위가 " + Constant.BEGIN_NUMBER.getValue() + "~"
            + Constant.END_NUMBER.getValue() + "까지가 아닌 숫자입니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    INVALID_NUMBER_COUNT("로또 번호의 개수가 " + Constant.REQUIRED_NUMBER_COUNT.getValue() + "개가 아닙니다.");

    private static final String ERROR_MESSAGE = "[ERROR]";

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
