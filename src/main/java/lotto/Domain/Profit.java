package lotto.Domain;

import lotto.Output.PrintOutput;

import java.util.Map;

public class Profit {
    public void printProfit(Map<String, Integer> winningMap, int userMoney) {
        double total =
                winningMap.get("three") * 5000 +
                winningMap.get("four") * 50000 +
                winningMap.get("five") * 1500000 +
                winningMap.get("six_YesBonus") * 30000000 +
                winningMap.get("six_YesBonus") * 2000000000;

        double profit = total/userMoney * 100;
        System.out.printf(PrintOutput.PROFIT.message(),profit);
    }
}
