package lotto.type;

public enum TextType {
    START("구입금액을 입력해 주세요."),
    LOTTO_WIN_NUMBER("당첨 번호를 입력해 주세요"),
    LOTTO_BONUS("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계."),
    INVALID_PRICE_INPUT("[ERROR] 구입 금액은 1000원 으로 나누어 떨어져야 합니다."),
    INVALID_WINNING_NUMBER_INPUT("[ERROR] 당첨 번호는 쉼표로 구분하여 6자리를 입력 하여야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 숫자는 1~45 사이의 숫자여야 합니다.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
