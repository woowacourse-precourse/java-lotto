package lotto.Domain.Statistic;

import lotto.Output.MainValue.PrintOutput;

import java.util.List;

public class Profit {
    public void printProfit(List<Integer> prizeRanks, int userMoney) {
        double total =
                prizeRanks.get(0) * 5000 +
                prizeRanks.get(1) * 50000 +
                prizeRanks.get(2) * 1500000 +
                prizeRanks.get(3) * 30000000 +
                prizeRanks.get(4) * 2000000000;

        double profit = (total / (userMoney * 1000)) * 100;
        System.out.printf(PrintOutput.PROFIT.message(), profit);
    }
}
