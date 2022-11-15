package lotto.domain;

public enum ErrorMessage {

    INVALID_RANGE("유효한 범위의 번호가 아닙니다."),
    DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_SIZE("유효한 번호 개수가 아닙니다."),
    NON_POSITIVE_INTEGER_VALUE("1이상의 정수가 아닙니다."),
    INVALID_PURCHASE_UNIT("로또는 1000원 단위로만 구매할 수 있습니다."),
    NON_POSITIVE_AMOUNT("구매 금액은 1000원 단위의 양의 정수로 구매하실 수 있습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
