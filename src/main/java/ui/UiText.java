package ui;

public enum UiText {
    ENTER_PURCHASE_AMOUNT("구입 금액을 입력해주세요."),
    BOUGHT_NUMBER(" 개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    THREE_MATCHES("3개 일치 (5,000)원 - "),
    FOUR_MATCHES("4개 일치 (50,000)원 - "),
    FIVE_MATCHES("5개 일치 (1,500,000)원 - "),
    FIVE_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000)원 - "),
    SIX_MATCHES("6개 일치 (2,000,000,000)원 - "),
    GROSS_RETURN("총 수익률은 ");

    private final String txt;

    UiText(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }
}
