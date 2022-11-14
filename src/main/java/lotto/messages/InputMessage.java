package lotto.messages;

public enum InputMessage {
    USER_MONEY_INPUT_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_LOTTERY_INPUT_MESSAGE("당첨 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
