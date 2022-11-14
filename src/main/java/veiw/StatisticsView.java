package veiw;

import constants.PrizeDivision;
import models.Statistics;

import java.util.Arrays;
import java.util.List;

public class StatisticsView {
    public static void printStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        printPrizeDivisionsAndAccumulatePrizeAmount(statistics);
        printRateOfReturn(statistics.getRateOfReturn());
    }

    private static void printPrizeDivisionsAndAccumulatePrizeAmount(Statistics statistics) {
        List<PrizeDivision> prizeDivision = Arrays.asList(PrizeDivision.values());

        for (int index = PrizeDivision.FIFTH.ordinal(); index >= PrizeDivision.FIRST.ordinal(); index--) {
            String matchingCount = prizeDivision.get(index).getMatchingCountText();
            int prizeAmount = prizeDivision.get(index).getPrizeAmount();
            int divisionCount = statistics.getDivisionsCount().get(index);

            System.out.println(matchingCount
                    + " (" + String.format("%,d", prizeAmount) + "원) - "
                    + divisionCount + "개");
        }
    }

    private static void printRateOfReturn(double rateOfReturn) {
        System.out.print("총 수익률은 " + String.format("%,.1f", rateOfReturn) + "%입니다.");
    }
}
