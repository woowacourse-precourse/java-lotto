package lotto.domain;

public class LottoYield {
    public static double computeYield(double totalPurchase){
        return (computeTotalRevenue()/totalPurchase)*100;
    }

    public static double computeTotalRevenue() {
        double totalRevenue = 0;

        for (LottoRank rank : LottoRank.values()) {
            totalRevenue += rank.getPrizeMoney();
        }

        return totalRevenue;
    }
}
