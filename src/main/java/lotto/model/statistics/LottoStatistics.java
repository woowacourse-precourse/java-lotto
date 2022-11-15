package lotto.model.statistics;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoStatistics {
    private final int totalPayment;
    private final Map<LottoResult, Integer> resultMap;

    LottoStatistics(int totalPayment, Map<LottoResult, Integer> resultMap) {
        this.totalPayment = totalPayment;
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

    public int getTotalPayment(int totalPayment) {
        return totalPayment;
    }
}
