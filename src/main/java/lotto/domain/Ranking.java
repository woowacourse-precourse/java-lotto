package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {

    FIRST_PLACE(6, 2_000_000_000L),
    SECOND_PLACE(5, 30_000_000L),
    THIRD_PLACE(5, 1_500_000L),
    FOURTH_PLACE(4, 50_000L),
    FIFTH_PLACE(3, 5_000L),
    NOTHING(0, 0L);

    private final int matchCount;
    private final long prizeMoney;

    Ranking(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public static Ranking getRanking(int matchCount, boolean bonusNumberHit) {
        Ranking rank = getRankingByHitCount(matchCount);
        return checkSecondPlace(rank, bonusNumberHit);
    }

    private static Ranking getRankingByHitCount(int matchCount) {
        return rankingsOrderByPriceMoneyAsc().stream()
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findAny()
                .orElse(NOTHING);
    }

    private static Ranking checkSecondPlace(Ranking ranking, boolean bonusNumberHit) {
        if (ranking == THIRD_PLACE && bonusNumberHit) {
            return SECOND_PLACE;
        }
        return ranking;
    }

    public static List<Ranking> rankingsOrderByPriceMoneyAsc() {
        return Arrays.stream(values())
                .filter(lottoPrize -> !lottoPrize.equals(NOTHING))
                .sorted(Comparator.comparingLong(rank -> rank.prizeMoney))
                .collect(Collectors.toList());
    }
}
