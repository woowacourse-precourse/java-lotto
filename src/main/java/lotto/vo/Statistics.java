package lotto.vo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lotto.domain.Money;
import lotto.domain.Rank;

public class Statistics {

    private final Map<Rank, Integer> statistics;

    public Statistics(List<Rank> ranks, Money capital) {
        this.statistics = createStatistics(ranks);
    }

    private Map<Rank, Integer> createStatistics(List<Rank> ranks) {
        Map<Rank, Integer> newStatistics = new TreeMap<>();
        for (Rank rank : Rank.values()) {
            int count = countRank(ranks, rank);
            newStatistics.put(rank, count);
        }
        return newStatistics;
    }

    private int countRank(List<Rank> ranks, Rank targetRank) {
        if (targetRank == Rank.NONE) {
            return 0;
        }
        return Math.toIntExact(ranks.stream()
                .filter(rank -> rank == targetRank)
                .count());
    }

    public int getCountOf(Rank rank) {
        return statistics.get(rank);
    }
}
