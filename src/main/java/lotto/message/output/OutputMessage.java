package lotto.message.output;

public enum OutputMessage {

    PURCHASE_COUNT_MESSAGE("%d개를 구매했습니다."),
    STATISTIC_TITLE_MESSAGE("당첨 통계\n---"),
    TOTAL_WIN_RATE_MESSAGE("총 수익률은 %.1f%%입니다."),
    THREE_COUNT_MATCH_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOUR_COUNT_MATCH_MESSAGE("4개 일치 (50,000원) - %d개"),
    FIVE_COUNT_MATCH_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    BONUS_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_COUNT_MATCH_MESSAGE("6개 일치 (2,000,000,000원) - %d개");

    public String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
