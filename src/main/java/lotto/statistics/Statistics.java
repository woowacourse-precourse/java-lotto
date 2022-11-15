package lotto.statistics;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.console.Constants;
import lotto.ticket.Winning;

public class Statistics {

    private Map<Winning, Integer> statisticsResult;
    private int rewards;

    public Statistics(List<Winning> drawResults) {
        this.statisticsResult = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            statisticsResult.put(winning, 0);
        }
        this.rewards = 0;

        generateStatistics(drawResults);
    }

    private void generateStatistics(List<Winning> drawResults) {
        for (Winning result : drawResults) {
            statisticsResult.put(result, statisticsResult.get(result) + 1);
        }
        calculateRewards();
    }


    public void printProfit(int moneyToBuy) {
        double profitRate = ((double) this.rewards / moneyToBuy) * 100;
        String profitRateRoundToFirst = String.format("%.1f", profitRate);
        System.out.printf(Constants.LOTTO_EARNINGS_RATE, profitRateRoundToFirst);
    }

    private void calculateRewards() {
        for (Winning winning : statisticsResult.keySet()) {
            addRewards(winning.getTotalRewards(statisticsResult.get(winning)));
        }
    }

    public Map<Winning, Integer> getStatisticsResult() {
        return statisticsResult;
    }

    private void addRewards(int rewards) {
        this.rewards += rewards;
    }
}
