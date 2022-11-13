package lotto.domain;

public class Yield {

    private final int yield;

    public Yield(int totalPurchase) {
        int totalRevenue = 0;
        for (Rank rank : Rank.values()) {
            totalRevenue += rank.getCount() * rank.getCashPrize();
        }
        yield = totalRevenue / totalPurchase * 100;
    }

    public int getYield() {
        return yield;
    }
}
