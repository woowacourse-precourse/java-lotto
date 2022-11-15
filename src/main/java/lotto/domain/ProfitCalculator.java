package lotto.domain;

import java.util.Map;

public class ProfitCalculator {
    private final double profit;

    public ProfitCalculator(Map<Rank, Integer> ranks, int purchaseAmount) {
        int earnMoney = calculateEarnMoney(ranks);
        this.profit = calculateProfit(earnMoney, purchaseAmount);
    }

    private int calculateEarnMoney(Map<Rank, Integer> ranks) {
        int earnMoney = 0;

        for (Map.Entry<Rank, Integer> rank : ranks.entrySet()) {
            earnMoney += rank.getKey().getPrizeMoney() * rank.getValue();
        }
        return earnMoney;
    }

    private double calculateProfit(int earnMoney, int purchaseAmount) {
        return ((double) earnMoney / (double) purchaseAmount) * 100;
    }

    public double getProfit() {
        return profit;
    }
}
