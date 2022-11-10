package lotto.constant;

public enum GameMessage {
    ASK_FOR_INITIAL_MONEY("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE("%d개를 구매했습니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int format_number) {
        return String.format(message, format_number);
    }
}
