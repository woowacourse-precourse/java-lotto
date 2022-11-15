package lotto.commons;

public enum InformationLines {
    BUY_AMOUNT_LINE("구입금액을 입력해 주세요."),
    WIN_NUMBER_LINE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_LINE("\n보너스 번호를 입력해 주세요."),
    WIN_STATS_LINE("\n당첨 통계\n---");

    private final String line;

    InformationLines(String line) {
        this.line = line;
    }

    public String getLine() {
        return this.line;
    }
}
