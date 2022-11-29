package lotto.vo;

import java.util.HashMap;
import java.util.Map;
import lotto.LottoRank;

public class LottoScore {

    private Map<LottoRank, Integer> lottoScore;

    public LottoScore() {
        lottoScore = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoScore.put(lottoRank, lottoScore.getOrDefault(lottoRank, 0));
        }

        this.lottoScore = lottoScore;
    }
}
