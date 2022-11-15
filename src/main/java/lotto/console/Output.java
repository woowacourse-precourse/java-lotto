package lotto.console;

import java.util.List;
import java.util.Map;
import lotto.statistics.Statistics;
import lotto.ticket.Lotto;
import lotto.ticket.Winning;

public class Output {

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printStatistics(Statistics statistics) {
        Map<Winning, Integer> statisticsResult = statistics.getStatisticsResult();
        System.out.println();
        System.out.println(Constants.STATISTICS_TITLE);
        System.out.println(Constants.STATISTICS_TITLE_SUFFIX);

        for (Winning winning : statisticsResult.keySet()) {
            int correctCount = winning.getCorrectCount();
            int rewards = winning.getRewards();
            int resultCount = statisticsResult.get(winning);

            printStatisticsDetail(winning, correctCount, rewards, resultCount);
        }
    }

    private static void printStatisticsDetail(Winning winning, int correctCount, int rewards,
            int resultCount) {
        if (winning == Winning.FAIL) {
            return;
        }

        if (winning == Winning.BONUS) {
            System.out.printf(Constants.STATISTICS_BONUS, correctCount, rewards,
                    resultCount);
            return;
        }

        System.out.printf(Constants.STATISTICS, correctCount, rewards, resultCount);
    }
}
