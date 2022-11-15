package lotto.domain.result;

import java.util.Map;
import java.util.Map.Entry;

public class Profit {

    private final int profit;
    private final double earningsRate;

    public Profit(int purchaseCost, HitResult result) {
        this.profit = calculateProfit(result);
        this.earningsRate = calculateEarningsRate(purchaseCost);
    }

    public double getEarningsRate() {
        return earningsRate;
    }

    public int calculateProfit(HitResult matchResults) {
        int profit = 0;
        Map<Rank, Integer> result = matchResults.getHitResultExceptNone();
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            profit += entry.getKey().getPrize() * entry.getValue();
        }
        return profit;
    }

    public double calculateEarningsRate(int purchaseCost) {
        double earningsRate = ((double) profit / purchaseCost) * 100;
        return (double) Math.round(earningsRate * 10) / 10;
    }
}
