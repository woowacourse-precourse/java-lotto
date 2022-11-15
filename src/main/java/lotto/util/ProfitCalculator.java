package lotto.util;

import lotto.domain.WinningRank;

import java.util.Map;

public class ProfitCalculator {

    public static long calculateTotalProfit(Map<WinningRank, Integer> winLottoCount) {
        long totalProfit = 0;
        for (WinningRank rank : WinningRank.values()) {
            totalProfit += (long) winLottoCount.getOrDefault(rank, 0) * rank.getPrizeMoney();
        }
        return totalProfit;
    }

    public static double calculateProfitRate(long totalProfit, int purchaseAmount) {
        double profitRate = totalProfit * 100.0 / purchaseAmount;

        return Math.round(profitRate * 10.0) / 10.0;
    }
}
