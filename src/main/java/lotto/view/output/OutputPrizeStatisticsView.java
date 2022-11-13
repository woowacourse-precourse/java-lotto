package lotto.view.output;

import lotto.domain.prize.PrizeStatistics;
import lotto.domain.prize.PrizeType;

public class OutputPrizeStatisticsView {

    public OutputPrizeStatisticsView(PrizeStatistics prizeStatistics) {
        System.out.println("\n당첨 통계\n---");

        for (PrizeType prizeType : prizeStatistics.getPrizeStatistics().keySet()) {
            if (prizeType.equals(PrizeType.NONE)) {
                continue;
            }

            System.out.println(prizeType.printNumOfMatched()
                    + prizeType.printPrizeMoney()
                    + " - "
                    + prizeStatistics.getCount(prizeType)
                    + "개");
        }
    }
}
