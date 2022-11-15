package lotto.constant;

public enum OutputConstant {
    LOTTO_QUANTITY_MESSAGE("\n%d개를 구매했습니다."),
    LOTTO_STAT_INTRO_MESSAGE("\n당첨 통계"),
    DIVIDING_LINE_MESSAGE("---"),
    MATCH_MESSAGE("%d개 일치"),
    PRIZE_MESSAGE(" (%s원)"),
    BONUS_PRIZE_MESSAGE(", 보너스 볼 일치"),
    COUNT_MESSAGE(" - %d개"),
    PROFIT_MESSAGE("총 수익률은 %.1f%%입니다."),
    ;

    private final String message;

    OutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
