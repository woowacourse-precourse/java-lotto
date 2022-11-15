package lotto.model;

import lotto.Enum.Rank;

import java.util.Map;

public class ProfitRate {
    private final double profitRate;

    public ProfitRate(Map<Rank, Integer> ranking, int purchaseAmount) {
        int prizeMoney = calculatePrizeMoney(ranking);
        this.profitRate = calculateProfitRate(prizeMoney, purchaseAmount);
    }

    public double getProfitRate() {
        return profitRate;
    }

    private int calculatePrizeMoney(Map<Rank, Integer> ranking) {
        int prizeMoney = 0;

        for (Rank rank : ranking.keySet()) {
            prizeMoney += rank.getRank().get(1) * ranking.get(rank);
        }

        return prizeMoney;
    }

    private double calculateProfitRate(int prizeMoney, int purchaseAmount) {
        return (double)prizeMoney / purchaseAmount * 100;
    }
}
