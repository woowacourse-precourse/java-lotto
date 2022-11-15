package lotto.enums;

public enum Error {
    PURCHASE_NUMERIC("구매 금액은 숫자만 입력 가능합니다."),
    PURCHASE_MIN("구매 금액이 1000원 미만입니다."),
    PURCHASE_UNIT("구매 금액은 1000원 단위로만 입력 가능합니다."),
    SIZE("로또 번호는 6개의 숫자로만 이루어질 수 있습니다."),
    DUPLICATE("로또 번호는 중복 값을 허용하지 않습니다."),
    LOTTO_NUMERIC("로또 번호는 숫자로만 입력 가능합니다."),
    LOTTO_RANGE("로또 번호는 1에서 45 사이의 숫자로만 이루어질 수 있습니다.");

    private static final String DEFAULT_MESSAGE = "[ERROR] ";
    private final String msg;
    Error(String errorMessage) {
        this.msg = DEFAULT_MESSAGE + errorMessage;
    }

    public String getError() {
        return msg;
    }
}
