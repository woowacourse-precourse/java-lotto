package lotto.statistics;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.ticket.Winning;
import lotto.console.Constants;

public class Statistics {

    private Map<Winning, Integer> statistics;
    private int rewards;

    public Statistics(List<Winning> drawResults) {
        this.statistics = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            statistics.put(winning, 0);
        }
        this.rewards = 0;

        generateStatistics(drawResults);
    }

    private void generateStatistics(List<Winning> drawResults) {
        for (Winning result : drawResults) {
            statistics.put(result, statistics.get(result) + 1);
        }
        calculateRewards();
    }

    public void printStatistics() {
        System.out.println();
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

    public void printProfit(int moneyToBuy) {
        double profitRate = ((double) this.rewards / moneyToBuy) * 100;
        String profitRateRoundToFirst = String.format("%.1f", profitRate);
        System.out.printf(Constants.LOTTO_EARNINGS_RATE, profitRateRoundToFirst);
    }

    private void calculateRewards() {
        for (Winning winning : statistics.keySet()) {
            addRewards(winning.getTotalRewards(statistics.get(winning)));
        }
    }

    private void addRewards(int rewards) {
        this.rewards += rewards;
    }
}
