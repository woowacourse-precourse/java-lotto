package lotto.domain;

import lotto.prizestandards.PrizeStandards;

import java.util.Map;

public class YieldCalculator {

    private static int convertResultIntoMoney(Map<Enum, Integer> winnerResult) { // public -> private 커밋 필요
        int allPrizeMoney = 0;

        for (Map.Entry<Enum, Integer> eachEntry : winnerResult.entrySet()) {
            int eachScore = ((PrizeStandards) eachEntry.getKey()).getMoney() * eachEntry.getValue();
            allPrizeMoney += eachScore;
        }

        return allPrizeMoney;
    }

    public static double computeYield(int buyingMoney, Map<Enum, Integer> winnerResult) {
        int allPrizeMoney = convertResultIntoMoney(winnerResult);

        return (allPrizeMoney / (double) buyingMoney) * 100;
    }
}
