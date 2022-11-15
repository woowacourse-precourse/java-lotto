package lotto;

import java.util.List;

public class Calculator {

    public double getProfitRate(List<Integer> results, int money) {
        validateResults(results);

        long profit = getProfit(results);
        double profitRate = profit / (double) money * 100;
        return profitRate;
    }

    private void validateResults(List<Integer> results) {
        if (results.size() != 5) {
            throw new IllegalArgumentException();
        }
    }

    private long getProfit(List<Integer> results) {
        long profit = 0L;
        Rank[] values = Rank.values();

        for (int i = 0; i < values.length; i++) {
            profit += values[i].getPrize() * results.get(i);
        }

        return profit;
    }
}
