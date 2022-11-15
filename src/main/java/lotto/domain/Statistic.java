package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final Map<Rank, Integer> statistics;

    private Statistic(List<Rank> ranks){
        this.statistics = new EnumMap<>(Rank.class);
        initStatistics();
        for (Rank rank : ranks) {
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    private void initStatistics() {
        Arrays.stream(Rank.values()).forEach(rank -> statistics.put(rank, 0));
    }

    public static Statistic valueOf(List<Rank> ranks) {
        return new Statistic(ranks);
    }
    public Map<Rank, Integer> getStatistics() {
        return new EnumMap<>(statistics);
    }

    public double getProfitRate(Price price) {
        double totalWinning = statistics.entrySet()
                .stream()
                .mapToDouble(rankIntegerEntry -> rankIntegerEntry.getKey().getWinningPrice() * rankIntegerEntry.getValue())
                .sum();
        return Math.round(totalWinning / price.getPrice() * 10) / 10.0;
    }
}
