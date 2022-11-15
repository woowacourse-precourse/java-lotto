package lotto.domain.statistics;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    private static final Integer INITIAL_COUNT = 0;

    private final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

    public Statistics(WinningLotto winningLotto, Lottos lottos) {
        setUp();
        calculateRank(winningLotto, lottos);
    }

    private void setUp() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, INITIAL_COUNT);
        }
    }

    private void calculateRank(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            final Rank rank = winningLotto.calculateRank(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(statistics);
    }

    public Money getReward() {
        final int reward = Arrays.stream(Rank.values())
                .mapToInt(this::getRankReward)
                .sum();
        return Money.create(reward);
    }

    private int getRankReward(Rank rank) {
        final Integer count = statistics.get(rank);
        return rank.getReward() * count;
    }

    public static Statistics create(WinningLotto winningLotto, Lottos lottos) {
        return new Statistics(winningLotto, lottos);
    }
}
