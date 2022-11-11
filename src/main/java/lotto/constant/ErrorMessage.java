package lotto.constant;

public enum ErrorMessage {
    UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE("구매 단위에 맞지 않게 입력하셨습니다"),
    CAN_NOT_EXIST_DUPLICATE_NUMBER_IN_LOTTO("로또에 중복된 숫자는 존재할 수 없습니다"),
    LOTTO_NUMBER_IS_OUT_OF_RANGE("범위 밖의 로또 번호입니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
