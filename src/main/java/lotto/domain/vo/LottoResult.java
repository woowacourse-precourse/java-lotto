package lotto.domain.vo;

import java.util.Map;
import lotto.domain.LottoReference;

public class LottoResult {

    private final Map<LottoReference, Integer> lottoResult;

    public LottoResult(Map<LottoReference, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<LottoReference, Integer> getValue() {
        return this.lottoResult;
    }

    @Override
    public String toString() {

        return lottoResult.toString();
    }
}
