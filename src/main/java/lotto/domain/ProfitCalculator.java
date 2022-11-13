package lotto.domain;

import java.util.Map;

public class ProfitCalculator {

    public static float calculateProfitRate(Map<Prize, Integer> prizeBoard, int money) {
        float profit = calculateProfit(prizeBoard);
        float profitRate = profit / money * 100;

        return (float) Math.round(profitRate * 100) / 100;
    }

    private static float calculateProfit(Map<Prize, Integer> prizeBoard) {
        float profit = prizeBoard.entrySet().stream()
            .mapToInt(it -> it.getKey().getMoney() * it.getValue())
            .sum();
        return profit;
    }

}
