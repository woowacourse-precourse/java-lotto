package lotto.type;

public enum TextType {
    START("구입금액을 입력해 주세요."),
    LOTTO_WIN_NUMBER("당첨 번호를 입력해 주세요"),
    PRICE_TO_NUMBER("개를 구매했습니다."),
    LOTTO_BONUS("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계.");


    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
