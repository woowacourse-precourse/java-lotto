package lotto.vo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lotto.domain.Money;
import lotto.domain.Rank;

public class Statistics {

    private final Map<Rank, Integer> statistics;
    private final Money profit;

    public Statistics(List<Rank> ranks) {
        this.statistics = createStatistics(ranks);
        this.profit = sumProfitsOf(ranks);
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

    private Money sumProfitsOf(List<Rank> ranks) {
        return ranks.stream()
                .map(Rank::getPrize)
                .reduce(Money::add)
                .orElse(new Money(0));
    }

    public int getCountOf(Rank rank) {
        return statistics.get(rank);
    }

    public Money getTotalProfit() {
        return profit;
    }
}
