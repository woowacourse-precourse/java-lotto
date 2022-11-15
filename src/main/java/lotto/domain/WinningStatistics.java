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

    public long calculateTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * countWonLottosByRank(rank);
        }
        return totalPrize;
    }
}
