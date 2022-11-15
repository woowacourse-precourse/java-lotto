package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    public double profitRate;
    private static final int MONEY_5 = 5000;
    private static final int MONEY_4 = 50000;
    private static final int MONEY_3 = 1500000;
    private static final int MONEY_2 = 30000000;
    private static final int MONEY_1 = 2000000000;
    public List<Integer> prizeMoney = new ArrayList<>(List.of(MONEY_5, MONEY_4, MONEY_3, MONEY_2, MONEY_1));

    public Profit(int inputMoney, List<Integer> prize) {
        calcProfit(inputMoney, prize);
    }

    private void calcProfit(int inputMoney, List<Integer> winningResult) {
        int totalProfit = 0;
        for (int i = 0; i < prizeMoney.size(); i++) {
            totalProfit += winningResult.get(i) * prizeMoney.get(i);
        }
        profitRate = (double) totalProfit / inputMoney * 100;
    }
}
