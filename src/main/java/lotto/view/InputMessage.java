package lotto.view;

public enum InputMessage {
    NOTICE_INPUT_PRICE("구입 금액을 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
