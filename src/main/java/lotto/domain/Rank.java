package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchNumber;
    private final int prize;

    Rank(final int matchNumber, final int prize) {
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int matchNumber() {
        return matchNumber;
    }

    public int prize() {
        return prize;
    }

    public static Rank find(int matchNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNumber == matchNumber)
                .findAny()
                .orElse(NOTHING);
    }
}
