package lotto.domain;

import java.util.Map;

public class RateCalculator {
    public int calculateWinningMoney(Map<Integer, Integer> winningMoney) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : winningMoney.entrySet()) {
            if (pair.getValue() > 0) {
                sum += pair.getKey();
            }
        }
        return sum;
    }

    public double calculateReturnOfRate(int purchaseMoney, int winningMoney) {
        double rateMoney = ((double) winningMoney / (double) purchaseMoney) * 100;
        if (rateMoney < 100) {
            rateMoney = Math.round(rateMoney * 100) / 100.0;
        }
        return rateMoney;
    }
}
