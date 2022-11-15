package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5, true),
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    NONE(0L, 0);

    long winningAmount;
    int coincideCount;
    boolean coincideBonus;

    Rank(long winningAmount, int coincideCount, boolean coincideBonus) {
        this.winningAmount = winningAmount;
        this.coincideCount = coincideCount;
        this.coincideBonus = coincideBonus;
    }

    Rank(long winningAmount, int coincideCount) {
        this(winningAmount, coincideCount, false);
    }

    public static Rank decide(long coincideCount, boolean coincideBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.coincideCount == coincideCount)
                .filter(rank -> rank.coincideBonus && coincideBonus)
                .findAny()
                .orElse(NONE);
    }
}
