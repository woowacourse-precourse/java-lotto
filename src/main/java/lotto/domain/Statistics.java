package lotto.domain;

import java.util.List;

public class Statistics {
    private Rank rank;

    public Statistics(List<Rank> rankings) {
        aggregateRankingsToStatistics(rankings);

    }

    private static void aggregateRankingsToStatistics(List<Rank> rankings) {
        for (Rank ranking : rankings) {
            ranking.addCount(ranking);
        }
    }

    public Rank getRank() {
        return rank;
    }
}
