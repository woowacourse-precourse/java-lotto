package lotto.domain;

import java.util.EnumMap;

public class LottoResult {

    private final EnumMap<LottoPrize, Integer> result;

    public LottoResult(EnumMap<LottoPrize, Integer> result) {
        this.result = result;
    }
}
