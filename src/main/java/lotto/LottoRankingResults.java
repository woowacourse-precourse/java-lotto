package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRankingResults {

    private Map<Ranking, Integer> rankingResults = new LinkedHashMap<>();
    private final int INITIAL_NUMBEROFWINNING = 0;

    public LottoRankingResults() {
        for (Ranking ranking : Ranking.values())
            rankingResults.put(ranking, INITIAL_NUMBEROFWINNING);
    }

    public void recordTheRanking(Ranking rank) {
        Integer numberOfWinning = rankingResults.get(rank);
        rankingResults.replace(rank, ++numberOfWinning);
    }

    public Map<Ranking, Integer> getRankingResults() {
        return rankingResults;
    }
}
