package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoCalculator {

    private Map<Rank, Integer> lottoResult = new HashMap<>();

    public void initLottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }
}
