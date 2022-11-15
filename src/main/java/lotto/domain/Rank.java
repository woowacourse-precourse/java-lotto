package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int count;
    private final boolean hasBonus;
    private final int prize;

    Rank(int count, boolean hasBonus, int prize) {
        this.count = count;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank of(int count, boolean hasBonus) {
        if (hasBonus && count == 4) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .filter(value -> value.hasBonus == hasBonus)
                .findFirst()
                .orElse(NONE);
    }

    public int prize() {
        return prize;
    }
}
