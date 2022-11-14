package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    public static final List<Integer> prizeMoney = new ArrayList<>(List.of(5000, 50000, 1500000, 30000000, 2000000000));
    public static double profitRate;

    public Profit(int price) {
        calculateProfit(price);
    }

    private void calculateProfit(int price) {
        int totalProfit = 0;
        for (int index = 0; index < 5; index++) {
            totalProfit += WinningResult.winningResult.get(index) * prizeMoney.get(index);
        }
        profitRate = (double) totalProfit / price * 100;
    }
}
