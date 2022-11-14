package lotto.Output.Statistic;

import lotto.Domain.Statistic.PrizeRankIndex;
import lotto.Output.MainValue.PrintOutput;

import java.util.List;

public class Profit {
    public void printProfit(List<Integer> prizeRanks, int userMoney) {
        double total =
                prizeRanks.get(PrizeRankIndex.THREE.getNum()) * 5000 +
                prizeRanks.get(PrizeRankIndex.FOUR.getNum()) * 50000 +
                prizeRanks.get(PrizeRankIndex.FIVE.getNum()) * 1500000 +
                prizeRanks.get(PrizeRankIndex.SIX_YES_BONUS.getNum()) * 30000000 +
                prizeRanks.get(PrizeRankIndex.SIX_NO_BONUS.getNum()) * 2000000000;

        double profit = (total / (userMoney * 1000)) * 100;
        System.out.printf(PrintOutput.PROFIT.message(), profit);
    }
}
