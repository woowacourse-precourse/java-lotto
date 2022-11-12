package lotto.entity;

import java.util.Map;

public class Result {

    private final Map<Rank, Integer> result;
    private final int purchase;

    public Result(Map<Rank, Integer> result, int purchase) {
        this.result = result;
        this.purchase = purchase;
    }

    public double calculateRateOfReturn() {
        double totalPrize = result.entrySet()
            .stream()
            .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
        return totalPrize / purchase * 100;
    }

}
