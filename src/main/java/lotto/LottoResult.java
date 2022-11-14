package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult(Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
