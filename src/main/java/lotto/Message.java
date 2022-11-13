package lotto;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요.");

    final String message;

    Message(String message) {
        this.message = message;
    }
}
