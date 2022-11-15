package lotto.domain;

import java.util.Map;

public class Result {
    private final Map<Rank, Integer> results;

    public Result(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        this.results = results;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
