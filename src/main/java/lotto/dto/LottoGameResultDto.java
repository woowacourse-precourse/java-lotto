package lotto.dto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicketsResult;
import lotto.domain.Profit;

import java.util.List;

public class LottoGameResultDto {
    private final List<LottoResult> results;
    private final double profit;

    public LottoGameResultDto(LottoTicketsResult lottoTicketsResult, Profit profit) {
        this.results = lottoTicketsResult.getResults();
        this.profit = profit.getProfit();
    }

    public List<LottoResult> getResults() {
        return results;
    }

    public double getProfit() {
        return profit;
    }
}
