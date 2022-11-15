package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {
    private Map<Result, Integer> countEachResult;
    private double yield;

    public WinningStatistics(Results results, int purchasePrice) {
        countEachResult = new EnumMap<>(Result.class);
        for (Result result : results.getResults()) {
            increaseResultCount(result);
        }
        calculateYield(purchasePrice);
    }

    public Map<Result, Integer> getCountEachResult() {
        return this.countEachResult;
    }

    public double getYield() {
        return this.yield;
    }

    private void increaseResultCount(Result result) {
        countEachResult.put(result, countEachResult.get(result) + 1);
    }

    private double calculateYield(int purchasePrice) {
        double totalPrizeMoney = countEachResult.entrySet()
                .stream()
                .mapToDouble(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return  (totalPrizeMoney / (double) purchasePrice) * 100;
    }
}
