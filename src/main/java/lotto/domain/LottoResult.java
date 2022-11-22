package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public LottoResult(List<LottoRank> lottoRanks) {
        putLottoResult(lottoRanks);
    }

    private void putLottoResult(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public long calPriceSum() {
        return lottoResult.entrySet().stream()
                .mapToLong(e -> e.getKey().multiple(e.getValue()))
                .sum();
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
    public int getRankCount(final LottoRank rank) {
        return this.lottoResult.getOrDefault(rank, 0);
    }
}
