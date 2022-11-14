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

    public double rateOfReturn() {
        return rateOfReturn;
    }

    public int count(Ranking ranking) {
        return results.get(ranking);
    }
}
