package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Result {

    private final Map<LottoRanking, Integer> result;

    public Result(EnumMap<LottoRanking, Integer> winningResult) {
        this.result = new EnumMap<>(winningResult);
    }

    public double prizeStatistic(Money money) {
        long sumOfPrize = result.entrySet()
                .stream()
                .mapToLong(this::prize)
                .sum();

        return (double) sumOfPrize / (double) money.money();
    }

    private long prize(Map.Entry<LottoRanking, Integer> rankWithCount) {
        return rankWithCount.getKey().prize() * rankWithCount.getValue();
    }

    public Map<LottoRanking, Integer> result() {
        return Collections.unmodifiableMap(result);
    }
}