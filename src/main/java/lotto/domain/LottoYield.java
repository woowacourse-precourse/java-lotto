package lotto.domain;

public class LottoYield {
    private static final int MULTIPLICATION_RATIO = 100;

    public static double computeYield(double totalPurchase){
        return (computeTotalRevenue()/totalPurchase)*MULTIPLICATION_RATIO;
    }

    public static double computeTotalRevenue() {
        double totalRevenue = 0;

        for (LottoRank rank : LottoRank.values()) {
            totalRevenue += rank.getPrizeMoney();
        }
        return totalRevenue;
    }
}
