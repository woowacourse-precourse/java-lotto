package lotto.domain.result;

import java.util.List;

public class ResultTable {
    List<Result> results;

    public ResultTable(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }
}
