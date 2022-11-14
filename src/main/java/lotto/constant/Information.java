package lotto.constant;

public enum Information {
    AMOUNT_OF_LOTTO("\n%d개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    COUNT_OF_WIN("%d개 일치%s (%s원) - %d개"),
    MATCH_WITH_BONUS(", 보너스 볼 일치"),
    YIELD("총 수익률은 %.1f%%입니다.");

    private final String message;

    Information(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
