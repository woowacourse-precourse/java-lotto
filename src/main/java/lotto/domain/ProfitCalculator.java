package lotto.domain;

import java.util.Map;

public class ProfitCalculator {

    private static final int RATE_UNIT = 100;

    public static float calculateProfitRate(Map<Prize, Integer> prizeBoard, Money money) {
        float profit = calculateProfit(prizeBoard);
        float profitRate = Money.calculateProfitRate(profit, money);
        return (float) Math.round(profitRate * RATE_UNIT) / RATE_UNIT;
    }

    private static float calculateProfit(Map<Prize, Integer> prizeBoard) {
        float profit = prizeBoard.entrySet().stream()
            .mapToInt(it -> it.getKey().getMoney() * it.getValue())
            .sum();
        return profit;
    }

}
