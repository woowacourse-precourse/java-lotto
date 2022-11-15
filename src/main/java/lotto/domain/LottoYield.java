package lotto.domain;

public class LottoYield {

    public static double computeTotalRevenue() {
        double totalRevenue = 0;

        for (LottoRank rank : LottoRank.values()) {
            totalRevenue += rank.getPrizeMoney();
        }

        return totalRevenue;
    }
}
