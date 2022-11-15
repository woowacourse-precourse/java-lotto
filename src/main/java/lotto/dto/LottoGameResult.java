package lotto.dto;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.LottoRanking;

public class LottoGameResult {

    private final List<LottoRanking> lottoRankings;
    private final Map<LottoRanking, Integer> lottoRankingCount;
    private final double profitRatio;

    public LottoGameResult(List<LottoRanking> lottoRankings,
        Map<LottoRanking, Integer> lottoRankingCount, double profitRatio) {
        this.lottoRankings = lottoRankings;
        this.lottoRankingCount = lottoRankingCount;
        this.profitRatio = profitRatio;
    }

    public List<LottoRanking> getLottoRankings() {
        return lottoRankings;
    }

    public Map<LottoRanking, Integer> getLottoRankingCount() {
        return lottoRankingCount;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
