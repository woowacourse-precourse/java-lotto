package lotto.domain;

import java.util.Map;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(Map<Integer, Integer> statisticsStore) {
        this.profitRate = calculateProfitRate(statisticsStore);
    }

    private double calculateProfitRate(Map<Integer, Integer> statisticsStore) {
        double paymentAmount = statisticsStore.values().stream()
                .mapToInt(i -> i)
                .sum() * 1000.0;
        int profit = 0;
        profit += statisticsStore.getOrDefault(5, 0) * 5000;
        profit += statisticsStore.getOrDefault(4, 0) * 50000;
        profit += statisticsStore.getOrDefault(3, 0) * 1500000;
        profit += statisticsStore.getOrDefault(2, 0) * 30000000;
        profit += statisticsStore.getOrDefault(1, 0) * 2000000000;
        double profitRate = profit / paymentAmount * 100;
        return Math.round((profitRate * 10)) / 10.0;
    }

    public double getProfitRate() {
        return this.profitRate;
    }
}
