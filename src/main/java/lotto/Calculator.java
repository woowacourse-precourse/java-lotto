package lotto;

import java.util.Map;

public class Calculator {
    private static final Integer POINT = 10;
    private static final Integer PERCENTAGE = 100;

    public static Float getProfit(Map<Comparison.Result, Integer> results, Integer purchasingAmount) {
        float totalProfit = 0;
        for (Map.Entry<Comparison.Result, Integer> result: results.entrySet()) {
            totalProfit += (result.getKey().getCash() * result.getValue());
        }
        return (totalProfit / purchasingAmount) * PERCENTAGE;
    }
}
