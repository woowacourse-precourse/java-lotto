package lotto.domain;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LottoResult {
    private Map<LottoRank, Integer> rank;
    private double yield;

    public LottoResult(Map<LottoRank, Integer> rank) {
        this.rank = rank;
        this.yield = calculateYield(rank);
    }

    public Map<LottoRank, Integer> getRank() {
        return rank;
    }

    public double getYield() {
        return yield;
    }

    private double calculateYield(Map<LottoRank, Integer> rank) {
        AtomicInteger count = new AtomicInteger();
        AtomicLong plusAmount = new AtomicLong();
        rank.forEach((key, value) -> {
            count.addAndGet(value);
            plusAmount.addAndGet(key.getReward() * value);
        });
        return plusAmount.get() / ((double) count.get() * Amount.LOTTO_AMOUNT) * 100.0;
    }
}
