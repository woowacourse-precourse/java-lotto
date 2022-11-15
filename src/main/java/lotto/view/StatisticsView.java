package lotto.view;

import lotto.domain.Statistics;

public class StatisticsView {
    public void printStatistics(Statistics statistics) {
        System.out.println(GuideMessage.STATISTICS_TITLE);
        System.out.println(GuideMessage.LINE);
        System.out.println(statistics);
    }

}
