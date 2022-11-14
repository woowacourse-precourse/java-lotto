package lotto.service;

import java.util.Map;
import lotto.domain.winning.LottoResults;
import lotto.domain.winning.Ranking;
import lotto.domain.winning.WinningStatistics;

public class FinalResultsDto {

    private final Map<Ranking, Integer> results;
    private final double rateOfReturn;

    FinalResultsDto(LottoResults lottoResults, WinningStatistics winningStatistics) {
        this.results = lottoResults.results();
        this.rateOfReturn = winningStatistics.rateOfReturn();
    }

    public Map<Ranking, Integer> results() {
        return results;
    }

    public double rateOfReturn() {
        return rateOfReturn;
    }
}
