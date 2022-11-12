package lotto.domain;

import java.util.List;

public class ProfitCalculator {
    public static double getProfit(List<Result> results, int invest) {
        double revenue = 0;
        for (WinningPrice winningPrice : WinningPrice.values()) {
            int numOfWinning = (int)results.stream()
                    .filter(winningPrice::isSameAsThis)
                    .count();
            revenue += winningPrice.getPrice() * numOfWinning;
        }
        return (revenue / invest) * 100;
    }
}
