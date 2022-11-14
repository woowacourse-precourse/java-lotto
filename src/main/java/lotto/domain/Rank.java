package lotto.domain;

import lotto.Statistic;

import java.util.HashMap;
import java.util.Map;

public class Rank {
    private final Map<Statistic, Integer> ranks;

    public Rank() {
        ranks = new HashMap<>();
        ranks.put(Statistic.SAME_SIX, 0);
        ranks.put(Statistic.SAME_FIVE_BONUS, 0);
        ranks.put(Statistic.SAME_FIVE, 0);
        ranks.put(Statistic.SAME_FOUR, 0);
        ranks.put(Statistic.SAME_THREE, 0);
    }

    public Map<Statistic, Integer> getRanks() {
        return ranks;
    }
}
