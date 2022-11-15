package lotto.model.statistics;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoStatistics {
    private final Map<LottoResult, Integer> resultMap;

    LottoStatistics(Map<LottoResult, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public int getLottoResultCount(LottoResult result) {
        return resultMap.getOrDefault(result, 0);
    }

    public int getTotalPrize() {
        AtomicInteger totalPrize = new AtomicInteger();
        resultMap.forEach((lottoResult, count) -> totalPrize.addAndGet(lottoResult.getPrize() * count));

        return totalPrize.get();
    }
}
