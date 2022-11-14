package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(2, false, 0);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final long prize;

    Rank(int matchCount, boolean hasBonusNumber, long prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank from(long matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NONE);
    }
}
