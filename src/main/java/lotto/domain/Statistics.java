package lotto.domain;

import java.util.List;

public class Statistics {
    private Rank rank;

    public Statistics(List<Rank> rankings) {
        for (Rank rank : rankings) {
            rank.initializeRankCount(rank);
        }
        aggregateRankingsToStatistics(rankings);
    }

    private static void aggregateRankingsToStatistics(List<Rank> rankings) {
        for (Rank ranking : rankings) {
            ranking.addCount(ranking);
        }
    }

    public Rank getRankWithStatistics() {
        return rank;
    }
}
