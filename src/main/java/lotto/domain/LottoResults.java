package lotto.domain;

import lotto.domain.enums.LottoResult;

import java.util.List;

public class LottoResults {
    private final List<LottoResult> results;

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public List<LottoResult> getResults() {
        return results;
    }
}
