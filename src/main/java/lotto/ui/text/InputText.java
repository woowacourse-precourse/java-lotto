package lotto.ui.text;

public enum InputText {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_BASIC_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_WINNING_NUMBER("보너스 번호를 입력해 주세요."),
    ;

    private final String text;

    InputText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
