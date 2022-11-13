package lotto;

public enum Wins {
    THREE_MATCHED("3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCHED("4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCHED("5개 일치 (1,500,000원) - %d개\n"),
    FIVE_WITH_BONUS_MATCHED("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCHED("6개 일치 (2,000,000,000원) - %d개");

    private final String infoMessage;
    private int count;

    Wins(String infoMessage) {
        this.infoMessage = infoMessage;
        this.count = 0;
    }

    public static String getWinningStats() {
        StringBuilder winningStats = new StringBuilder();
        for (Wins win : Wins.values()) {
            winningStats.append(String.format(win.infoMessage, win.count));
        }

        return winningStats.toString();
    }

    public static void countWinningLotto(int matchingCount, boolean isBonusMatched) {
        if (matchingCount == 3) {
            THREE_MATCHED.count++;
            return;
        }
        if (matchingCount == 4) {
            FOUR_MATCHED.count++;
            return;
        }
        if (matchingCount == 5 && !isBonusMatched) {
            FIVE_MATCHED.count++;
            return;
        }
        if (matchingCount == 5 && isBonusMatched) {
            FIVE_WITH_BONUS_MATCHED.count++;
            return;
        }
        if (matchingCount == 6) {
            SIX_MATCHED.count++;
        }
    }
}
