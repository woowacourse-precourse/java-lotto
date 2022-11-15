package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    Map<LottoRank, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        initResult();
    }

    private void initResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

}
