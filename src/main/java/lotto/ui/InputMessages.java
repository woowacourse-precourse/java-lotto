package lotto.ui;

public enum InputMessages {
    MONEY("구입금액을 입력해 주세요."),
    LOTTO("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    private final String action;
    InputMessages(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}