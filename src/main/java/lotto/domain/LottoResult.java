package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final Long ZERO = 0L;

    private EnumMap<LottoPrize, Long> result = new EnumMap<>(LottoPrize.class);

    public LottoResult(Map<LottoPrize, Long> result) {
        this.result.putAll(result);
    }

    public Integer getCount(LottoPrize lottoPrize) {
        return result.getOrDefault(lottoPrize, ZERO).intValue();
    }
}
