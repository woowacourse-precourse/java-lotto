package lotto;

public enum OutputMessage {
    PRICE("구입금액을 입력해 주세요.");

    String message;
    private OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
