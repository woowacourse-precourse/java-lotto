package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(2, 0);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank from(long matchCount, boolean hasBonusNumber) {
        if (isThird(matchCount, hasBonusNumber)) {
            return THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isThird(long matchCount, boolean hasBonusNumber) {
        return matchCount == THIRD.matchCount && !hasBonusNumber;
    }
}
