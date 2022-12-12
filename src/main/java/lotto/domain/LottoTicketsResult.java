package lotto.domain;

import java.util.List;

public class LottoTicketsResult {
    private final List<LottoResult> results;

    public LottoTicketsResult(List<LottoResult> results) {
        this.results = results;
    }

    public int getWinningAmountSum() {
        return results.stream()
                .mapToInt(LottoResult::getAmount)
                .sum();
    }

    public List<LottoResult> getResults() {
        return results;
    }
}
