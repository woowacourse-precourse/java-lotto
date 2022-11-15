package lotto.model;

import lotto.model.enums.Prize;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    public List<Integer> prizeMoney = new ArrayList<>(List.of(Prize.PRIZE_3.getPrize(), Prize.PRIZE_4.getPrize(), Prize.PRIZE_5.getPrize(), Prize.PRIZE_5BONUS.getPrize(), Prize.PRIZE_6.getPrize()));
    public double profitRate;

    public Profit(int price, List<Integer> winningResult) {
        calculateProfit(price, winningResult);
    }

    private void calculateProfit(int price, List<Integer> winningResult) {
        int totalProfit = 0;
        for (int index = 0; index < 5; index++) {
            totalProfit += winningResult.get(index) * prizeMoney.get(index);
        }
        profitRate = (double) totalProfit / price * 100;
    }
}
