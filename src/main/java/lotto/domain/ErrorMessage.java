package lotto.domain;

public enum ErrorMessage {
    INVALID_RANGE("유효한 범위의 번호가 아닙니다."),
    DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_SIZE("유효한 번호 개수가 아닙니다."),
    INVALID_LOTTO_FORMAT("당첨 번호는 콤마(\",\")로 구분되어 입력되어야합니다."),
    NON_NUMERIC_VALUE("숫자만 입력할 수 있습니다."),
    INVALID_PURCHASE_UNIT("로또는 1000원 단위로만 구매할 수 있습니다."),
    MINIMUM_PURCHASE_QUANTITY("로또는 1장 이상으로 구매하실 수 있습니다."),
    NON_POSITIVE_AMOUNT("구매 금액은 1000원 단위의 양의 정수로 구매하실 수 있습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
