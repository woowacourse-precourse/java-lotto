package view;

public enum InputMessage {
    MONEY_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_MESSAGE("당첨번호를 입력해 주세요."),
    WINNING_BONUS_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }

}

