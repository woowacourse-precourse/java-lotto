package lotto;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoAnalyst {

    public LottoGradeCounter analyze(List<LottoGrade> lottoResults) {
        LottoGradeCounter counter = new LottoGradeCounter();
        lottoResults.forEach(counter::countByOne);

        return counter;
    }

    public double getYield(LottoGradeCounter lotto) {
        AtomicInteger atomicInvest = new AtomicInteger();
        AtomicInteger atomicProfit = new AtomicInteger();
        lotto.forEach((key, value) -> {
            atomicInvest.addAndGet(value * LottoSetting.PRICE.getValue());
            atomicProfit.addAndGet(value * key.getPrice());
        });

        return (double) atomicProfit.get() / atomicInvest.get() * 100;
    }
}
