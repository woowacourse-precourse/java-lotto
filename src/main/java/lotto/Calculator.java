package lotto;

import java.util.List;

public class Calculator {

    public double getProfitRate(List<Integer> results, int money) {
        long profit = getProfit(results);
        double profitRate = profit / money;
        return profitRate;
    }

    private long getProfit(List<Integer> results) {
        return 0L;
    }
}
