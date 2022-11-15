package lotto.dto;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.LottoRanking;

public class LottoGameResult {

    private final List<LottoRanking> lottoRankings;
    private final Map<LottoRanking, Integer> lottoRankingCount;

    public LottoGameResult(List<LottoRanking> lottoRankings,
        Map<LottoRanking, Integer> lottoRankingCount) {
        this.lottoRankings = lottoRankings;
        this.lottoRankingCount = lottoRankingCount;
    }

    public List<LottoRanking> getLottoRankings() {
        return lottoRankings;
    }

    public Map<LottoRanking, Integer> getLottoRankingCount() {
        return lottoRankingCount;
    }
}
