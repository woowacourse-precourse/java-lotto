package lotto.domain;

import lotto.data.LottoRank;

import java.util.Map;

public class RewardCalculator {

    private double createProfitInFirstDecimal(long totalRevenue, long price) {
        double profit = (double) totalRevenue / price * 100;

        return Math.round(profit * 10) / (double) 10;
    }

    private long createTotalRevenue(Map<LottoRank, Integer> winningCounts) {
        long totalRevenue = 0L;

        for (LottoRank lottoRank : winningCounts.keySet()) {
            int winningAmount = winningCounts.get(lottoRank);
            totalRevenue += winningAmount * lottoRank.getReward();
        }

        return totalRevenue;
    }

    public double calculateProfit(Map<LottoRank, Integer> winningCounts, long price) {
        long totalRevenue = createTotalRevenue(winningCounts);

        return createProfitInFirstDecimal(totalRevenue, price);
    }
}
