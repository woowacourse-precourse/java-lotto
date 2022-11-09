package lotto.global;

public enum Message {

    GAME_INPUT("구입금액을 입력해 주세요.");

    private final String message;

    Message(String s) {
        this.message = s;
    }

    public void print() {
        System.out.println(message);
    }
}
