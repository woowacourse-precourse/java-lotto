package lotto.model;

import lotto.model.enums.Prize;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    public static final List<Integer> prizeMoney = new ArrayList<>();
    public static double profitRate;

    public Profit(int price, WinningResult winningResult) {
        setPrize();
        calculateProfit(price, winningResult);
    }

    private void setPrize() {
        prizeMoney.addAll(List.of(Prize.PRIZE_3.getPrize(), Prize.PRIZE_4.getPrize(), Prize.PRIZE_5.getPrize(), Prize.PRIZE_5BONUS.getPrize(), Prize.PRIZE_6.getPrize()));
    }

    private void calculateProfit(int price, WinningResult winningResult) {
        int totalProfit = 0;
        for (int index = 0; index < 5; index++) {
            totalProfit += winningResult.winningResult.get(index) * prizeMoney.get(index);
        }
        profitRate = (double) totalProfit / price * 100;
    }
}
