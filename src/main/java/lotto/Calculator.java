package lotto;

import java.util.List;

public class Calculator {

    public double getProfitRate(List<Integer> results, int money) {
        long profit = getProfit(results);
        double profitRate = profit / money;
        return profitRate;
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
