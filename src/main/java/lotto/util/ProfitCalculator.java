package lotto.util;

import lotto.domain.WinningRank;

import java.util.Map;

public class ProfitCalculator {

    public static int calculateTotalProfit(Map<WinningRank, Integer> winLottoCount) {
        int totalProfit = 0;
        for (WinningRank rank : WinningRank.values()) {
            totalProfit += winLottoCount.getOrDefault(rank, 0) * rank.getPrizeMoney();
        }
        return totalProfit;
    }

    public static double calculateProfitRate(int totalProfit, int purchaseAmount) {
        double profitRate = totalProfit * 100.0 / purchaseAmount;

        return Math.round(profitRate * 10.0) / 10.0;
    }
}
