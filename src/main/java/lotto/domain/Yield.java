package lotto.domain;

public class Yield {

    private final String yield;

    public Yield(double totalPurchase) {
        double totalRevenue = 0;
        for (Rank rank : Rank.values()) {
            totalRevenue += rank.getCount() * rank.getCashPrize();
        }
        this.yield = String.format("%.1f", totalRevenue / totalPurchase * 100);
    }

    public String getYield() {
        return yield;
    }
}
