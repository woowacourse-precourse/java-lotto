package lotto;

import java.util.List;

public class ProfitRateCalculator {

    public double calculate(List<Lotto> lottos, int investmentMoney, List<Integer> winningNumber, int bonusNumber) {
        double totalWinningMoney = 0;
        for (int i = 0; i < lottos.size(); i++) {
            totalWinningMoney += lottos.get(i).matchRank(winningNumber, bonusNumber).getMoney();
        }
        double profitRate = (totalWinningMoney / (double) investmentMoney) * 100;
        profitRate = Math.round(profitRate*100)/100.0;
        return profitRate;
    }
}
