package lotto.ENUMS;

public enum UIMessages {
    ENTER_PURCHASE_AMOUNT("구입 금액을 입력하세요."),
    BUY_LOTTOS("개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계\n---"),
    TOTAL_EARNINGS("총 수익률은"),
    IS("입니다."),
    UNIT("개"),
    WON("원");

    String text;

    UIMessages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
