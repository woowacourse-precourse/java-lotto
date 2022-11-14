package lotto.domain;

import java.util.Map;

public class ProfitCalculator {

    private double profit;

    public ProfitCalculator(Map<Rank, Integer> ranks, int purchaseMoney) {
        int earnMoney = calculateEarnMoney(ranks);
        this.profit = calculateProfit(earnMoney, purchaseMoney);
    }

    private int calculateEarnMoney(Map<Rank, Integer> ranks) {
        int earnMoney = 0;

        for (Map.Entry<Rank, Integer> rank : ranks.entrySet()) {
            earnMoney += rank.getKey().getPrize() * rank.getValue();
        }
        return earnMoney;
    }

    private double calculateProfit(int earnMoney, int purchaseMoney) {
        return Math.round((double) earnMoney / purchaseMoney * 10) / 10.0;
    }

    public double getProfit() {
        return profit;
    }
}
