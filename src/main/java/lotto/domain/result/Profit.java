package lotto.domain.result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Map<Integer, Integer> result = matchResults.getResult();
        List<Integer> prizeMoneys = Stream.of(Rank.values())
                .map(Rank::getPrize)
                .collect(Collectors.toList());
        for (int index = 0; index < result.size(); index++) {
            if (result.get(index) > 0) {
                profit += (result.get(index) * prizeMoneys.get(index));
            }
        }
        return profit;
    }

    public double calculateEarningsRate(int purchaseCost) {
        double earningsRate = ((double) profit / purchaseCost) * 100;
        return (double) Math.round(earningsRate * 10) / 10;
    }
}
