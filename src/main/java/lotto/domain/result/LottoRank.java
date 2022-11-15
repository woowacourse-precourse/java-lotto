package lotto.domain.result;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private final int matchingCount;
    private final int prizeMoney;

    LottoRank(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getLottoRankResult(int matchingCount, boolean bonusNumberMatching) {
        LottoRank lottoRank = Arrays.asList(LottoRank.values())
                .stream()
                .filter(rank -> rank.matchingCount == matchingCount)
                .findFirst()
                .orElse(FAIL);

        if (lottoRank == SECOND && !bonusNumberMatching) {
            lottoRank = THIRD;
        }

        return lottoRank;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
