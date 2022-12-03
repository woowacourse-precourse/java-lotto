package lotto.domain.game;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.Player;

public class LottoResult {

    private static final int GRADE_PLUS_VALUE = 1;

    private final Map<LottoRanking, Integer> lottoRankingResult = new EnumMap<>(LottoRanking.class);
    private final BigDecimal revenuePercent;

    public LottoResult(final Player player, final Lotto winningLotto, final LottoNumber bonusNumber) {
        List<LottoRanking> lottoRankings = player.calculateLottoRanking(winningLotto, bonusNumber);

        addRankingCount(lottoRankings);
        BigDecimal totalReward = calculateTotalReward();
        revenuePercent = player.calculateRevenuePercent(totalReward);
    }

    private void addRankingCount(final List<LottoRanking> lottoRankings) {
        lottoRankings.forEach(
            ranking ->
                lottoRankingResult.put(ranking,
                    lottoRankingResult.getOrDefault(ranking, 0) + GRADE_PLUS_VALUE));
    }

    private BigDecimal calculateTotalReward() {
        return lottoRankingResult.keySet()
                .stream()
                .filter(LottoRanking::hasReward)
                .map(this::calculateTargetLottoRankingTotalReward)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTargetLottoRankingTotalReward(final LottoRanking target) {
        return target.calculateTotalTargetLottoRankingReward(lottoRankingResult.get(target));
    }

    public Map<LottoRanking, Integer> getLottoRankingResult() {
        return lottoRankingResult;
    }

    public BigDecimal getRevenuePercent() {
        return revenuePercent;
    }
}
