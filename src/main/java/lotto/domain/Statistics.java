package lotto.domain;

import java.util.List;

public class Statistics {

    public Statistics(List<Rank> rankings) {
        aggregateRankingStatistics(rankings);
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
