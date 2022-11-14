package lotto;

import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.EnumMap;

public class Calculator extends Kiosk {
    public static float getYield(int payment, EnumMap<RankNumber, Integer> resultStatistics) {
        return (getTotalWinnings(resultStatistics) / (float)payment) * 100;
    }

    public static int getTotalWinnings(EnumMap<RankNumber, Integer> resultStatistics) {
        int totalWinnings = 0;
        for (RankNumber rank : RankNumber.values()) {
            totalWinnings += resultStatistics.get(rank) * Winnings.getAmount(rank.toString());
        }
        return totalWinnings;
    }

    public static float getRoundedYield(float yield) {
        return Math.round(yield * 100) / 100.0f;
    }
}
