package lotto;

import constants.LottoConstants;

public enum Wins {
    THREE_MATCHED("3개 일치 (5,000원) - %d개\n", 5000),
    FOUR_MATCHED("4개 일치 (50,000원) - %d개\n", 50_000),
    FIVE_MATCHED("5개 일치 (1,500,000원) - %d개\n", 1_500_000),
    FIVE_WITH_BONUS_MATCHED("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30_000_000),
    SIX_MATCHED("6개 일치 (2,000,000,000원) - %d개", 2_000_000_000);

    private final String infoMessage;
    private final int winnings;
    private int count;

    Wins(String infoMessage, int winnings) {
        this.infoMessage = infoMessage;
        this.winnings = winnings;
        this.count = 0;
    }

    public static double getProfitRate(int purchaseAmount) {
        int profit = 0;
        for (Wins win : Wins.values()) {
            profit += (win.winnings * win.count);
        }

        return (double) profit / purchaseAmount * LottoConstants.PERCENTAGE_UNIT;
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
