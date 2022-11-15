package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRankingResults {

    private Map<Ranking, Integer> rankingResults = new LinkedHashMap<>();

    public LottoRankingResults() {
        for (Ranking ranking : Ranking.values())
            rankingResults.put(ranking, 0);
    }

    public void recordTheRanking(Ranking rank) {
        Integer count = rankingResults.get(rank) + 1;
        rankingResults.replace(rank, count++);
    }

    public Map<Ranking, Integer> getRankingResults() {
        return rankingResults;
    }

}
