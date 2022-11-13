package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoAnalyst {

    public Map<LottoGrade, Integer> analyze(List<LottoGrade> lottoResults) {
        Map<LottoGrade, Integer> lottoMatchMap = new EnumMap<>(LottoGrade.class);
        for(LottoGrade lottoGrade : LottoGrade.values()) {
            lottoMatchMap.put(lottoGrade, 0);
        }
        lottoResults.forEach(
            lottoResult -> lottoMatchMap.put(lottoResult, lottoMatchMap.get(lottoResult) + 1)
        );

        return lottoMatchMap;
    }

    public double getYield(Map<LottoGrade, Integer> lotto) {
        AtomicInteger atomicInvest = new AtomicInteger();
        AtomicInteger atomicProfit = new AtomicInteger();
        lotto.forEach((key, value) -> {
            atomicInvest.addAndGet(value * 1000);
            atomicProfit.addAndGet(value * key.getPrice());
        });

        return (double)atomicProfit.get()/atomicInvest.get() * 100;
    }
}
