package lotto.entity;

import static lotto.LottoApplication.PRICE;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class Result {

    private final Map<Rank, Integer> result;

    public Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public double calculateRateOfReturn() {
        double totalPrize = getTotalPrize();
        int purchase = getPurchase();
        return totalPrize / purchase * 100;
    }

    private double getTotalPrize() {
        return result.entrySet()
            .stream()
            .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }

    private int getPurchase() {
        int count = result.values()
            .stream()
            .mapToInt(i -> i)
            .sum();
        return count * PRICE;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner("\n");
        result.entrySet()
            .stream()
            .sorted(new Comparator<Entry<Rank, Integer>>() {
                @Override
                public int compare(Entry<Rank, Integer> o1, Entry<Rank, Integer> o2) {
                    return o1.getKey().getPrize() - o2.getKey().getPrize();
                }
            })
            .forEach(
                entry -> output.add(entry.getKey().toString() + " - " + entry.getValue() + "개"));
        return output.toString();
    }

}
