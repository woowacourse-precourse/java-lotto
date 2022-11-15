package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST_PLACE(6, 2_000_000_000L),
    SECOND_PLACE(5, 30_000_000L),
    THIRD_PLACE(5, 1_500_000L),
    FOURTH_PLACE(4, 50_000L),
    FIFTH_PLACE(3, 5_000L),
    NOTHING(0, 0L);

    private final int matchCount;
    private final long prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public Long calculatePrizeMoney(Long count) {
        return this.prizeMoney * count;
    }

    public static LottoRank getLottoRank(int matchCount, boolean bonusNumberHit) {
        LottoRank rank = getLottoRankByHitCount(matchCount);
        return checkSecondPlace(rank, bonusNumberHit);
    }

    private static LottoRank getLottoRankByHitCount(int matchCount) {
        return lottoRanksOrderByPriceMoneyAsc().stream()
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findAny()
                .orElse(NOTHING);
    }

    private static LottoRank checkSecondPlace(LottoRank lottoRank, boolean bonusNumberHit) {
        if (lottoRank == THIRD_PLACE && bonusNumberHit) {
            return SECOND_PLACE;
        }
        return lottoRank;
    }

    public static List<LottoRank> lottoRanksOrderByPriceMoneyAsc() {
        return Arrays.stream(values())
                .filter(lottoPrize -> !lottoPrize.equals(NOTHING))
                .sorted(Comparator.comparingLong(rank -> rank.prizeMoney))
                .collect(Collectors.toList());
    }
}
