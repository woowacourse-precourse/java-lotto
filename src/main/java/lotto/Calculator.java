package lotto;

import enumCollections.RankNumber;
import enumCollections.Winnings;

import java.util.EnumMap;

public class Calculator {
    static final int PERCENTAGE = 100;
    static final double NUMBER_FOR_DIGIT = 10.0;

    public static Double getYield(int payment, EnumMap<RankNumber, Integer> resultStatistics) {
        return getRoundedYield((getTotalWinnings(resultStatistics) / (double) payment) * PERCENTAGE);
    }

    private static int getTotalWinnings(EnumMap<RankNumber, Integer> resultStatistics) {
        int totalWinnings = 0;
        for (RankNumber rank : RankNumber.values()) {
            totalWinnings += resultStatistics.get(rank) * Winnings.getAmount(rank.toString());
        }
        return totalWinnings;
    }

    private static double getRoundedYield(double yield) {
        return Math.round(yield * NUMBER_FOR_DIGIT) / NUMBER_FOR_DIGIT;
    }
}
