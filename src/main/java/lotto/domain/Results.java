package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results() {
        this.results = new ArrayList<>();
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public Statistics generateStatistics() {
        Statistics statistics = new Statistics();

        for (Result result : results) {
            Prize prize = Prize.generatePrize(result);
            statistics.updateStatistics(prize);
        }
        return statistics;
    }

    public List<Result> getResults() {
        return results;
    }
}
