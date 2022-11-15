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
    boolean hasBonus;

    Rank(int winningAmount, int coincideCount, boolean hasBonus) {
        this.winningAmount = winningAmount;
        this.coincideCount = coincideCount;
        this.hasBonus = hasBonus;
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

    public static Rank decide(long coincideCount, boolean hasBonusNumber) {
        if (isWinningSecond(coincideCount, hasBonusNumber)) {
            return SECOND;
        }

        return findRank(coincideCount);
    }

    private static Rank findRank(long coincideCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.coincideCount == coincideCount)
                .filter(rank -> !rank.hasBonus)
                .findAny()
                .orElse(NONE);
    }

    private static boolean isWinningSecond(long coincideCount, boolean hasBonusNumber) {
        return (coincideCount == 5) && hasBonusNumber;
    }
}
