package lotto.domain.vo;

import java.util.Map;
import lotto.domain.LottoReference;

public class LottoResult {
    private Map<LottoReference, Integer> lottoResult;

    public LottoResult(Map<LottoReference, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }
    public Map<LottoReference, Integer> getValue() {
        return this.lottoResult;
    }
}
