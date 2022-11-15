package lotto.domain;

import java.util.List;

public class Statistics {

    public Statistics(List<Rank> rankings) {
        initializeStatistics(rankings);
        aggregateRankingsToStatistics(rankings);
    }

    private static void initializeStatistics(List<Rank> rankings) {
        for (Rank rank : rankings) {
            rank.initializeRankCount(rank);
        }
    }

    private static void aggregateRankingsToStatistics(List<Rank> rankings) {
        for (Rank ranking : rankings) {
            ranking.addCount(ranking);
        }
    }

    public List<Rank> getRankWithStatistics() {
         return List.of(Rank.values());
    }


}
