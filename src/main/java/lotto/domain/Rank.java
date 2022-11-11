package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NOTHING(0, 0);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;

    }

    public static Rank of(int count, boolean hasBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.count == count)
            .filter(rank -> !rank.equals(THIRD) || !hasBonus)
            .findFirst().orElse(NOTHING);
    }
}
