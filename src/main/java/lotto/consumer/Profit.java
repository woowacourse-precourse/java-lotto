package lotto.consumer;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Ranks;

public class Profit {
    private final List<Integer> profit;

    public Profit(int matchingWinningNumberCount, int matchingBonusNumberCount) {
        profit = new ArrayList<>();
        updateProfit(matchingWinningNumberCount, matchingBonusNumberCount);
    }

    public List<Integer> getProfit() {
        return profit;
    }

    public void updateProfit(int matchingWinningNumberCount, int matchingBonusNumberCount) {
        Integer prizeMoney = Ranks.getPrizeMoneyBy(matchingWinningNumberCount, matchingBonusNumberCount);
        profit.add(prizeMoney);
    }
}
