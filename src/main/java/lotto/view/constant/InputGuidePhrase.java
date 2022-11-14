package lotto.view.constant;

public enum InputGuidePhrase {
    PURCHASE_MONEY_REQUEST("구입금액을 입력해 주세요."),
    WINNING_NUMBER_REQUEST("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_REQUEST("보너스 번호를 입력해 주세요.");

    private final String text;

    private InputGuidePhrase(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}