package lotto.vo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lotto.domain.Money;
import lotto.constant.Rank;

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
            int frequency = countRankFrequency(ranks, rank);
            newStatistics.put(rank, frequency);
        }
        return newStatistics;
    }

    private int countRankFrequency(List<Rank> ranks, Rank objectiveRank) {
        return Collections.frequency(ranks, objectiveRank);
    }

    private Money sumProfitsOf(List<Rank> ranks) {
        return ranks.stream()
                .map(Rank::getPrize)
                .reduce(Money::add)
                .orElse(new Money(0));
    }

    public int getFrequencyOf(Rank rank) {
        return statistics.get(rank);
    }

    public Money getTotalProfit() {
        return profit;
    }
}
