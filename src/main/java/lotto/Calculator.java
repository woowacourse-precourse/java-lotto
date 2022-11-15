package lotto;

import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.EnumMap;

public class Calculator {
    public static Double getYield(int payment, EnumMap<RankNumber, Integer> resultStatistics) {
        return getRoundedYield((getTotalWinnings(resultStatistics) / (double) payment) * 100);
    }

    private static int getTotalWinnings(EnumMap<RankNumber, Integer> resultStatistics) {
        int totalWinnings = 0;
        for (RankNumber rank : RankNumber.values()) {
            totalWinnings += resultStatistics.get(rank) * Winnings.getAmount(rank.toString());
        }
        return totalWinnings;
    }

    private static double getRoundedYield(double yield) {
        return Math.round(yield * 10.0) / 10.0;
    }
}
