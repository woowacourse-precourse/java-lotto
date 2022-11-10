package lotto.constant;

public enum StringConstant {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    StringConstant(String message, int result) {
        this.message = String.valueOf(result) + message;
    }
    public String getMessage() {
        return message;
    }
}
