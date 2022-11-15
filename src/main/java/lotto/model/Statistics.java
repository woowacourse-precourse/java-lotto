package lotto.model;

import java.util.List;

public class Statistics {

    public Statistics(List<Rank> rankings) {
        aggregateRankingStatistics(rankings);
    }

    private static void aggregateRankingStatistics(List<Rank> rankings) {
        rankings.stream().forEach(ranking -> ranking.addCount(ranking));
    }

    public List<Rank> getStatistics() {
        return List.of(Rank.values());
    }


}
