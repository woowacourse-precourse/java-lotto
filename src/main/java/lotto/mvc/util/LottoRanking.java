package lotto.mvc.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRanking {
    RANKING_NOTHING(
            new BigDecimal(0L),
            0L,
            correctBonus -> true),

    RANKING_FIFTH(
            new BigDecimal(5_000L),
            3L,
            correctBonus -> true),

    RANKING_FOURTH(
            new BigDecimal(50_000L),
            4L,
            correctBonus -> true),

    RANKING_THIRD(
            new BigDecimal(1_500_000L),
            5L,
            correctBonus -> !correctBonus),

    RANKING_SECOND(
            new BigDecimal(30_000_000L),
            5L,
            correctBonus -> correctBonus),

    RANKING_FIRST(
            new BigDecimal(2_000_000_000L),
            6L,
            correctBonus -> true);

    private static final DecimalFormat rewardFormat = new DecimalFormat("(###,###원)");

    private final BigDecimal lottoRankingReward;
    private final long correctNumberCount;
    private final Predicate<Boolean> correctBonusNumberPredicate;

    LottoRanking(BigDecimal lottoRankingReward, long correctNumberCount,
            Predicate<Boolean> correctBonusNumberPredicate) {
        this.lottoRankingReward = lottoRankingReward;
        this.correctNumberCount = correctNumberCount;
        this.correctBonusNumberPredicate = correctBonusNumberPredicate;
    }

    public String findRewardMessage() {
        return rewardFormat.format(lottoRankingReward);
    }

    public BigDecimal calculateTotalTargetLottoRankingReward(int numberOfWins) {
        return lottoRankingReward.multiply(new BigDecimal(numberOfWins));
    }

    public static LottoRanking findLottoRanking(long correctNumberCount, boolean isCorrectBonusNumber) {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.correctNumberCount == correctNumberCount)
                .filter(lottoRanking -> lottoRanking.correctBonusNumberPredicate.test(isCorrectBonusNumber))
                .findAny()
                .orElse(LottoRanking.RANKING_NOTHING);
    }
}
