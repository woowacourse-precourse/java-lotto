package lotto.Enum;

public enum StatisticMessage {
    STATISTIC("당첨 통계\n---"),
    WINNING_5RANK("3개 일치 (5,000원) - "),
    WINNING_4RANK("4개 일치 (50,000원) - "),
    WINNING_3RANK("5개 일치 (1,500,000원) - "),
    WINNING_2RANK("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_1RANK("6개 일치 (2,000,000,000원) - "),
    SUFFIX("개"),
    TOTAL_YIELD("총 수익률은 %.1f%%입니다.\n");

    private String message;

    private StatisticMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int count) {
        return message + count + SUFFIX;
    }
}
