package lotto.entity;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

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
