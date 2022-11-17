package lotto.constant.message;

public enum OutputMessage {

    PURCHASE_COUNT("개를 구매했습니다.")
    , WINNING_STATS("당첨 통계\n---")
    , WINNING_STATS_RESULT("%d개 일치 (%s원) - %d개\n")
    , WINNING_STATS_BONUS_RESULT("5개 일치, 보너스 볼 일치 (%s원) - %d개\n")
    , EARNING_RATE("총 수익률은 %.1f%%입니다.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
