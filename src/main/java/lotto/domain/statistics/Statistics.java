package lotto.domain.statistics;

import lotto.domain.money.Money;
import lotto.domain.rank.Rank;
import lotto.domain.yield.Yield;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Statistics {

    private final Map<Rank, Long> statistics;
    private final Yield yield;

    private Statistics(Map<Rank, Long> statistics, Yield yield) {
        this.statistics = new EnumMap<>(statistics);
        this.yield = yield;
    }

    public static Statistics of(Money money, List<Rank> ranks) {

        Map<Rank, Long> result = ranks.stream()
                .collect(Collectors.groupingBy(r -> r, counting()));

        int totalReword = ranks.stream()
                .map(Rank::getReward)
                .map(Money::value)
                .reduce(0, Integer::sum);

        return new Statistics(
                result,
                Yield.calculate(money.value(), totalReword)
        );
    }

    public long count(Rank rank) {
        if (statistics.get(rank) == null) {
            return 0;
        }
        return statistics.get(rank);
    }

    public double yield() {
        return yield.getPercent();
    }
}
