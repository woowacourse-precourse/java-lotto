package lotto.view;

public enum InputMessage {
    MONEY("구입금액을 입력해 주세요."),
    LOTTO("\n당첨 번호를 입력해 주세요."),
    BONUS("\n보너스 번호를 입력해 주세요.");
    private final String message;
    InputMessage(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
