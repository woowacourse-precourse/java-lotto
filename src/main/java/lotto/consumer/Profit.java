package lotto.consumer;

import lotto.machine.Ranks;

public class Profit {
    private final Integer profit;

    public Profit(int matchingWinningNumberCount, int matchingBonusNumberCount) {
        profit = updateProfit(matchingWinningNumberCount, matchingBonusNumberCount);
    }

    public Integer getProfit() {
        return profit;
    }

    public Integer updateProfit(int matchingWinningNumberCount, int matchingBonusNumberCount) {
        return Ranks.getPrizeMoneyBy(matchingWinningNumberCount, matchingBonusNumberCount);
    }
}
