package lotto.domain.winning;

import java.util.Map;

public class LottoResults {

    private final Map<Ranking, Integer> results;

    public LottoResults(Map<Ranking, Integer> results) {
        this.results = results;
    }

    long totalWinnings() {
        long count = 0;
        for (Ranking ranking : results.keySet()) {
            count += ranking.sumOfWinnings(results.get(ranking));
        }
        return count;
    }

    public Map<Ranking, Integer> results() {
        return Map.copyOf(results);
    }
}