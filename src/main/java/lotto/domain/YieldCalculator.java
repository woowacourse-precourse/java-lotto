package lotto.domain;

import lotto.prizestandards.PrizeStandards;
import lotto.ui.input.PriceGetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YieldCalculator {

    public int convertResultIntoMoney(Map<Enum, Integer> winnerResult) {
        int allPrizeMoney = 0;

        for (Map.Entry<Enum, Integer> eachEntry : winnerResult.entrySet()) {
            int eachScore = ((PrizeStandards)eachEntry.getKey()).getMoney() * eachEntry.getValue();
            allPrizeMoney += eachScore;
        }

        return allPrizeMoney;
    }

    public double computeYield(int buyingMoney, Map<Enum, Integer> winnerResult) {
        int allPrizeMoney = convertResultIntoMoney(winnerResult);

        return (allPrizeMoney / (double) buyingMoney) * 100;
    }
}
