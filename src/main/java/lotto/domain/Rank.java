package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(6),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NONE;

    int coincideCount;

    Rank(int coincideCount) {
        this.coincideCount = coincideCount;
    }

    Rank() {
    }

    public static Rank decide(long coincideCount, boolean coincideBonus) {
        Rank rank = findRank(coincideCount);
        if (rank == FIRST || rank == SECOND) {
            rank = checkBonus(coincideBonus);
        }

        return rank;
    }

    private static Rank checkBonus(boolean coincideBonus) {
        if (coincideBonus) {
            return SECOND;
        }

        return FIRST;
    }

    private static Rank findRank(long coincideCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.coincideCount == coincideCount)
                .findAny()
                .orElse(NONE);
    }
}
