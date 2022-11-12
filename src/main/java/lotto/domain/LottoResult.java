package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import lotto.util.ranking.LottoRanking;

public class LottoResult {

    private static final int GRADE_PLUS_VALUE = 1;

    private final Map<LottoRanking, Integer> lottoRankingResult = new EnumMap<>(LottoRanking.class);

    public void addRankingCount(LottoRanking lottoRanking) {
        lottoRankingResult.put(lottoRanking, lottoRankingResult.getOrDefault(lottoRanking, 0) + GRADE_PLUS_VALUE);
    }

    public BigDecimal calculateTotalReward() {
        return lottoRankingResult.keySet()
                .stream()
                .filter(lottoRanking -> lottoRanking != LottoRanking.RANKING_NOTHING)
                .map(this::calculateTargetLottoRankingTotalReward)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTargetLottoRankingTotalReward(LottoRanking target) {
        return target.calculateTotalTargetLottoRankingReward(lottoRankingResult.get(target));
    }
}
