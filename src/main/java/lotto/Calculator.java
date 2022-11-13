package lotto;

import enumCollections.RankIndex;
import enumCollections.Winnings;

public class Calculator extends Kiosk {
    public static float getYield(int payment) {
        return (getTotalWinnings() / payment) * 100;
    }

    public static int getTotalWinnings() {
        int totalWinnings = 0;
        for (RankIndex rank : RankIndex.values()) {
            totalWinnings += resultStatistics[rank.ordinal()] * Winnings.getAmount(rank.name());
        }
        return totalWinnings;
    }

    public static float getRoundedYield(float yield) {
        return Math.round(yield * 100) / 100.0f;
    }
}
