package lotto.model;

import java.util.List;

public class Statistics {

    public Statistics(List<Rank> playerRankings) {
        aggregateRankingStatistics(playerRankings);
    }

    private static void aggregateRankingStatistics(List<Rank> playerRankings) {
        playerRankings.stream().forEach(playerRanking -> playerRanking.addCount(playerRanking));
    }

    public List<Rank> getStatistics() {
        return List.of(Rank.values());
    }

}
