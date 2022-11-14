package lotto.domain;

import java.util.stream.Stream;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0);

    private final int matchingCount;
    private final int prizeMoney;

    Prize(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int lottoMatchingCount, boolean bonusMatching) {
        if (lottoMatchingCount == THIRD.matchingCount && !bonusMatching) {
            return THIRD;
        }
        return Stream.of(values())
                .filter(prize -> prize.matchingCount == lottoMatchingCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

}
