package lotto.service;

import lotto.Enum.Ranking;

import java.util.Map;

public class CalProfitPercent {
    private static final int ZERO = 0;
    private static final double HUNDRED = 100.0;

    public double calProfitPercent(Map<Ranking, Integer> winningResults, int money) {
        double resultMoney = ZERO;
        for (Ranking ranking : Ranking.values()) {
            resultMoney += winningResults.get(ranking) * ranking.money();
        }
        return Math.round(resultMoney / money * HUNDRED * HUNDRED) / HUNDRED;
    }

}
