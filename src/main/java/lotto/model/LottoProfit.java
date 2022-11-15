package lotto.model;

import java.util.Map;

public class LottoProfit {
    private final double profit;

    public LottoProfit(Map<Integer, Integer> totalRank, int purchaseAmount) {
        double rateOfReturn = calculateRateOfReturn(totalRank, purchaseAmount);
        this.profit = rateOfReturn;
    }

    public double getProfit() {
        return profit;
    }

    public double calculateRateOfReturn(Map<Integer, Integer> totalRank, int purchaseAmount) {
        double rateOfReturn = (double) calculateSumOfPrize(totalRank) / (double) purchaseAmount;
        return rateOfReturn;
    }

    private long calculateSumOfPrize(Map<Integer, Integer> totalRank) {
        long sumOfPrize = 0;
        sumOfPrize += totalRank.get(1) * 2000000000L;
        sumOfPrize += totalRank.get(2) * 30000000L;
        sumOfPrize += totalRank.get(3) * 1500000L;
        sumOfPrize += totalRank.get(4) * 50000L;
        sumOfPrize += totalRank.get(5) * 5000L;
        return sumOfPrize;
    }
}
