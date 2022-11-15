package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5, true),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NONE(0);

    int coincideCount;
    boolean coincideBonus;


    Rank(int coincideCount, boolean coincideBonus) {
        this.coincideCount = coincideCount;
        this.coincideBonus = coincideBonus;
    }

    Rank(int coincideCount) {
        this(coincideCount, false);
    }

    public static Rank decide(long coincideCount, boolean coincideBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.coincideCount == coincideCount)
                .filter(rank -> rank.coincideBonus && coincideBonus)
                .findAny()
                .orElse(NONE);
    }
}
