package lotto.constant;

public enum ErrorMessage {
    UNIT_OF_LOTTO_PURCHASE_DOES_NOT_COMPLY_WITH_RULE("구매 단위에 맞지 않게 입력하셨습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
