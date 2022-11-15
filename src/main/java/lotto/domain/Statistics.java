package lotto.domain;

import java.util.List;

public class Statistics {

    public Statistics(List<Rank> rankings) {
        initializeCountsInRank(rankings);
        aggregateRankingStatistics(rankings);
    }

    private static void initializeCountsInRank(List<Rank> rankings) {
        for (Rank rank : rankings) {
            rank.initializeRankCount(rank);
        }
    }

    private static void aggregateRankingStatistics(List<Rank> rankings) {
        for (Rank ranking : rankings) {
            ranking.addCount(ranking);
        }
    }

    public List<Rank> getStatistics() {
         return List.of(Rank.values());
    }


}
