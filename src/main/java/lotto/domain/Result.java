package lotto.domain;

import java.util.Map;

public class Result {
    private final Map<Rank, Integer> results;

    public Result(Map<Rank, Integer> results) {
        this.results = results;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
