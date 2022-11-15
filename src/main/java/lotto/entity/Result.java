package lotto.entity;

import static lotto.LottoApplication.PRICE;

import java.util.Comparator;
import java.util.Map;
import java.util.StringJoiner;

public class Result {

    private final Map<Rank, Integer> result;

    public Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public double calculateRateOfReturn() {
        double totalPrize = getTotalPrize();
        long purchase = getPurchase();
        return totalPrize / purchase * 100;
    }

    private double getTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private long getPurchase() {
        long count = result.values()
                .stream()
                .mapToLong(i -> i)
                .sum();
        return count * PRICE;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner("\n");
        result.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Rank.NONE))
                .sorted(Comparator.comparingLong(o -> o.getKey().getPrize()))
                .forEach(
                        entry -> output.add(entry.getKey() + " - " + entry.getValue() + "개"));
        return output.toString();
    }

}