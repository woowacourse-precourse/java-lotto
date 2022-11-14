package lotto;

import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.EnumMap;

public class Calculator extends Kiosk {
    public static float getYield(int payment, EnumMap<RankNumber, Integer> resultStatistics) {
        return getRoundedYield((getTotalWinnings(resultStatistics) / (float) payment) * 100);
    }

    private static int getTotalWinnings(EnumMap<RankNumber, Integer> resultStatistics) {
        int totalWinnings = 0;
        for (RankNumber rank : RankNumber.values()) {
            totalWinnings += resultStatistics.get(rank) * Winnings.getAmount(rank.toString());
        }
        return totalWinnings;
    }

    private static float getRoundedYield(float yield) {
        return Math.round(yield * 10) / 10.0f;
    }
}
