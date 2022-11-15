package lotto.domain;

import static lotto.domain.LottoInfo.*;

import java.util.Map;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(Map<Integer, Integer> statisticsStore) {
        this.profitRate = calculateProfitRate(statisticsStore);
    }

    private double calculateProfitRate(Map<Integer, Integer> statisticsStore) {
        double paymentAmount = calculatePaymentAmount(statisticsStore);
        int profit = calculateProfit(statisticsStore);
        double profitRate = calculateProfitRate(paymentAmount, profit);
        return Math.round((profitRate * 10)) / 10.0;
    }

    private static double calculateProfitRate(double paymentAmount, int profit) {
        return profit / paymentAmount * 100;
    }

    private static int calculateProfit(Map<Integer, Integer> statisticsStore) {
        int profit = 0;
        for (int winning = 1; winning < 6; winning++) {
            profit += statisticsStore.getOrDefault(winning, BLANK.getWinningPrize())
                    * price.get(winning).getWinningPrize();
        }
        return profit;
    }

    private static double calculatePaymentAmount(Map<Integer, Integer> statisticsStore) {
        return statisticsStore.values().stream()
                .mapToInt(i -> i)
                .sum() * 1000.0;
    }

    public double getProfitRate() {
        return this.profitRate;
    }
}
