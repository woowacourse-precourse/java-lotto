package lotto;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    private static final List<Integer> prizeMoney = new ArrayList<>(List.of(5000, 50000, 1500000, 30000000, 2000000000));
    private static double profitRate;

    public Profit(int price) {
        calculateProfit(price);
        printProfitRate();
    }

    private void calculateProfit(int price) {
        int totalProfit = 0;
        for (int index = 0; index < 5; index++) {
            totalProfit += Winning.winningResult.get(index) * prizeMoney.get(index);
        }
        profitRate = (double) totalProfit / price * 100;
    }

    private void printProfitRate() {
        System.out.println(GameMessage.PROFIT_HEAD_MESSAGE.getMessage() + profitRate + GameMessage.PROFIT_TAIL_MESSAGE.getMessage());
    }


}
