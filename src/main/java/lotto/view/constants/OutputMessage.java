package lotto.view.constants;

public enum OutputMessage {
    ASK_PAYMENT("구입금액을 입력해주세요."),
    ASK_DRAW_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_DRAW_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INFORM_TOTAL_LOTTO_RESULT("당첨통계\n---");

    private final String text;

    OutputMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
