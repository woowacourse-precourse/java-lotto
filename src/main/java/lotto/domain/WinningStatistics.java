package lotto.domain;

import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> statistics;

    public WinningStatistics(Map<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public int countWonLottosByRank(Rank rank) {
        return statistics.getOrDefault(rank, 0);
    }
}
