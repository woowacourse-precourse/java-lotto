package lotto.model;

import static lotto.util.Constants.PERCENT_MULTIPLICATION;
import static lotto.util.Util.formatYield;

import java.util.List;

public class Yield {
    private final String yield;

    public Yield(double totalBudget, List<Rank> ranks) {
        double totalRevenue = calculateTotalRevenue(ranks);
        this.yield = formatYield(totalBudget, totalRevenue);
    }

    private static double calculateTotalRevenue(List<Rank> ranks) {
        double totalRevenue = 0;
        for (Rank rank : ranks) {
            totalRevenue += rank.getCount() * rank.getCashPrize();
        }
        return totalRevenue;
    }

    public static double calculateYield(double totalPurchase, double totalRevenue) {
        return totalRevenue / totalPurchase * PERCENT_MULTIPLICATION;
    }

    public String getYield() {
        return yield;
    }
}
