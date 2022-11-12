package lotto.view.message;

public enum FixedMessage {
    INPUT_PRICE("구입금액을 입력해 주세요.");

    private final String message;

    FixedMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
