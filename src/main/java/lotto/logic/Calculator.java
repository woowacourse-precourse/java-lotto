package lotto.logic;

import lotto.model.WinningRank;

import java.util.Map;

public class Calculator {
    public static int getProfit(Map<WinningRank, Integer> winResult) {
        int result = 0;
        for (Map.Entry<WinningRank, Integer> entry : winResult.entrySet()) {
            result += entry.getKey().calculateTotalMoneyByTheNumber(entry.getValue());
        }
        return result;
    }
    public static double getEarningsRate(int purchaseCost, Map<WinningRank,Integer> winResult) {
        return Math.round(((double) getProfit(winResult) / (double) purchaseCost) * 1000) /10.0;
    }
}
