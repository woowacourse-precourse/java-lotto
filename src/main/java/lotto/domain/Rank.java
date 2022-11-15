package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6);

    int winningAmount;
    int coincideCount;
    boolean coincideBonus;

    Rank(int winningAmount, int coincideCount, boolean coincideBonus) {
        this.winningAmount = winningAmount;
        this.coincideCount = coincideCount;
        this.coincideBonus = coincideBonus;
    }

    Rank(int winningAmount, int coincideCount) {
        this(winningAmount, coincideCount, false);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getCoincideCount() {
        return coincideCount;
    }

    public static Rank decide(long coincideCount, boolean coincideBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.coincideCount == coincideCount)
                .filter(rank -> !rank.equals(SECOND) || coincideBonus)
                .findAny()
                .orElse(NONE);
    }
}
