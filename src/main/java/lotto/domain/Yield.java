package lotto.domain;

import static lotto.util.Formatter.formatYield;

public class Yield {

    public static final int PERCENT_MULTIPLICATION = 100;
    private final String yield;

    public Yield(double totalPurchase) {
        double totalRevenue = calculateTotalRevenue();
        this.yield = formatYield(totalPurchase, totalRevenue);
    }

    private static double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Rank rank : Rank.values()) {
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
