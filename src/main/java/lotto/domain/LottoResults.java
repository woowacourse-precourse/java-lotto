package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private static final double TENTHS = 10.0;

    private final Map<LottoRank, Integer> lottoResults;

    public LottoResults(List<LottoRank> lottoRankResults) {
        Map<LottoRank, Integer> lottoResults = new HashMap<>();
        for (LottoRank lottoRank : lottoRankResults) {
            lottoResults.put(lottoRank, lottoResults.getOrDefault(lottoRank, 0) + 1);
        }
        this.lottoResults = lottoResults;
    }

    public double getRatioOfReturn() {
        long lottoRewardSum = getLottoRewardSum();
        int lottoCount = getLottoCount();
        return Math.round(lottoRewardSum / lottoCount) / TENTHS;
    }

    public int getLottoResult(LottoRank lottoRank) {
        return lottoResults.getOrDefault(lottoRank, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }

    private int getLottoCount() {
        int lottoCount = 0;
        for (LottoRank lottoRank : lottoResults.keySet()) {
            lottoCount += lottoResults.getOrDefault(lottoRank, 0);
        }
        return lottoCount;
    }

    private long getLottoRewardSum() {
        long lottoRewardSum = 0L;
        for (Map.Entry<LottoRank, Integer> lottoRank : lottoResults.entrySet()) {
            lottoRewardSum += lottoRank.getKey().getReward() * lottoRank.getValue();
        }
        return lottoRewardSum;
    }
}
