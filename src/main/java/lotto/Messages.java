package lotto;

public enum Messages {
    REQUEST_MONEY("구입금액을 입력해 주세요.");

    final String message;

    Messages(String message) {
        this.message = message;
    }
}
