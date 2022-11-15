package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {

    private static final String SEPARATOR = ",";
    private static final String NULL = "";
    private static final int PERCENTILE = 100;
    private static final int ZERO = 0;

    private final Map<Rank, Integer> result;

    public Result(List<Rank> ranks) {
        this.result = new EnumMap<>(Rank.class);
        initResult();

        for (Rank rank : ranks) {
            if (rank == Rank.NON) continue;

            result.put(rank, result.getOrDefault(rank, ZERO) + 1);
        }
    }

    public void initResult() {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NON) continue;
            result.put(rank, ZERO);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getYield(int purchaseMoney) {
        double totalWinningMoney = result.entrySet()
                .stream()
                .mapToDouble(rank -> Integer.parseInt(rank.getKey().getWinningPrice().replaceAll(SEPARATOR, NULL)) * rank.getValue())
                .sum();

        return totalWinningMoney / purchaseMoney * PERCENTILE;
    }
}
