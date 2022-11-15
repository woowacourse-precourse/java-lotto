package view;

public enum Text {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NOTICE_NUMBER_OF_LOTTO("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    NOTICE_RESULT("당첨 통계\n---"),
    FIFTH_PLACE("3개 일치 (5,000원) - "),
    FOURTH_PLACE("4개 일치 (50,000원) - "),
    THIRD_PLACE("5개 일치 (1,500,000원) - "),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - "),
    COUNT("개"),
    NOTICE_RATE_OF_RETURN("총 수익률은 "),
    NOTICE_PERCENT("%입니다."),
    ROUND("%.1f");

    private final String outputText;

    Text(String outputText) {
        this.outputText = outputText;
    }

    @Override
    public String toString() {
        return this.outputText;
    }

    public String getText() {
        return this.outputText;
    }
}
