package lotto.domain.result;

import java.util.Map;
import java.util.Map.Entry;

public class Profit {

    private static final double DECIMAL = 10.0;
    private static final int RATIO = 100;
    private final long profit;
    private final double earningsRate;

    public Profit(int purchaseCost, HitResult result) {
        this.profit = calculateProfit(result);
        this.earningsRate = calculateEarningsRate(purchaseCost);
    }

    public double getEarningsRate() {
        return earningsRate;
    }

    public long calculateProfit(HitResult matchResults) {
        long profit = 0;
        Map<Rank, Integer> result = matchResults.getHitResultExceptNone();
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            profit += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return profit;
    }

    public double calculateEarningsRate(int purchaseCost) {
        double earningsRate = ((double) profit / purchaseCost) * RATIO;
        return Math.round(earningsRate * DECIMAL) / DECIMAL;
    }
}
