package lotto.service;

import java.util.Map;

public class Calculator {

    public static int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public static long sumWinningPrize(Map<Integer, Integer> prizes) {
        long totalWinningPrize = 0L;
        for (Map.Entry<Integer, Integer> prize : prizes.entrySet()) {
            totalWinningPrize += (long) prize.getKey() * prize.getValue();
        }
        return totalWinningPrize;
    }
}