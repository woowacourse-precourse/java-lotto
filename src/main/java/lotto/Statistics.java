package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private Map<Winning, Integer> statistics;

    public Statistics() {
        statistics = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            statistics.put(winning, 0);
        }
    }

    public void generateStatistics(List<Winning> drawResults) {
        for (Winning result : drawResults) {
            statistics.put(result, statistics.get(result) + 1);
        }
    }

    public void printStatistics() {
        System.out.println(Constants.STATISTICS_TITLE);
        System.out.println(Constants.STATISTICS_TITLE_SUFFIX);

        for (Winning winning : statistics.keySet()) {
            int correctCount = winning.getCorrectCount();
            int rewards = winning.getRewards();
            int resultCount = statistics.get(winning);

            printStatisticsDetail(winning, correctCount, rewards, resultCount);
        }
    }

    private void printStatisticsDetail(Winning winning, int correctCount, int rewards,
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
