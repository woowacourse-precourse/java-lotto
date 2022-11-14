package lotto.service;

import lotto.Enum.Ranking;

import java.util.Map;

public class CalProfitPercent {
    public double calProfitPercent(Map<Ranking, Integer> winningResults, int money) {
        double resultMoney = 0;
        for (Ranking ranking : Ranking.values()) {
//            if (winningResults.get(ranking) > 0) {
                resultMoney += winningResults.get(ranking) * ranking.money();
//            }
        }
        return Math.round(resultMoney / money * 100 * 100) / 100.0;
    }
}
