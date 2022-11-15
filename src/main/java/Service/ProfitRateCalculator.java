package Service;

import lotto.Ranking;

import java.util.Map;
import java.util.Set;

public class ProfitRateCalculator {
    private final int PERCENT = 100;

    public double calculator(int purchaseAmount, Map<Ranking, Integer> rankingResults) {
        Set<Ranking> rankings = rankingResults.keySet();
        int prizeMoney = 0;
        double profitRate;

        for (Ranking ranking : rankings) {
            Integer numberOfWin = rankingResults.get(ranking);
            String money = ranking.getMoney().replaceAll(",", "");
            prizeMoney += numberOfWin * Integer.valueOf(money);
        }
        profitRate = roundDecimalPoint((double) prizeMoney / purchaseAmount * PERCENT);
        return profitRate;
    }

    private double roundDecimalPoint(double profitRate) {
        return (Math.round(profitRate * 10) / 10.0);
    }
}
