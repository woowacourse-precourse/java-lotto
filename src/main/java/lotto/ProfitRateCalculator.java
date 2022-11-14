package lotto;

import java.util.List;
import java.util.Map;

public class ProfitRateCalculator {

    public double calculate(Map<Rank, Integer> rankResult, int investmentMoney) {
        double totalWinningMoney = 0;
        for (Rank key: rankResult.keySet()){
            totalWinningMoney += key.getMoney() * rankResult.get(key);
        }
        double profitRate = (totalWinningMoney / (double) investmentMoney) * 100;
        profitRate = Math.round(profitRate*100)/100.0;
        return profitRate;
    }
}
