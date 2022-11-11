package lotto.message;

public enum ConsoleMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
