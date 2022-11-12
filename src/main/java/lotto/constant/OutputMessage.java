package lotto.constant;

public enum OutputMessage {

    PURCHASE_COUNT("개를 구매하였습니다.")
    , WINNING_STATS("당첨 통계\n---")
    , WINNING_STATS_RESULT("%d개 일치 (%d원) - %d개")
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
