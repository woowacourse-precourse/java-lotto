package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private List<Result> results;

    public Results() {
        this.results = new ArrayList<>();
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }
}
