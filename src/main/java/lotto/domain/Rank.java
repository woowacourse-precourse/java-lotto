package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOT(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private static final int SPECIAL_CASE = 5;

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Rank find(int matchCount, boolean isBonusBall) {
        if (matchCount == SPECIAL_CASE) {
            return checkBonus(isBonusBall);
        }
        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(NOT);
    }

    private static Rank checkBonus(boolean isBonusBall) {
        if (isBonusBall) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
