package lotto.enums;

public enum Error {
    PURCHASE_NUMERIC("[ERROR] 구매 금액은 숫자만 입력 가능합니다."),
    PURCHASE_UNIT("구매 금액은 1000원 단위로만 입력 가능합니다.");

    private static final String DEFAULT_MESSAGE = "[ERROR] ";
    private final String msg;
    Error(String errorMessage) {
        this.msg = DEFAULT_MESSAGE + errorMessage;
    }

    public String getError() {
        return msg;
    }
}
