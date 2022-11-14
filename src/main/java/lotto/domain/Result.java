package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result = new EnumMap<Rank, Integer>(Rank.class);

    public Result() {
        initResult();
    }

    private void initResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public float calculateProfit(int price) {
        return ((float) getTotalReward() / (float) price) * 100;
    }

    private long getTotalReward() {
        return result
                .entrySet()
                .stream()
                .mapToLong(entry ->
                        entry.getKey().getReward() * entry.getValue()
                )
                .sum();
    }
}
