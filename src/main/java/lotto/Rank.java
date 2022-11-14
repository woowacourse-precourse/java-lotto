package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    OUT(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int match;
    private final long money;

    Rank(int match, long money) {
        this.match = match;
        this.money = money;
    }

    public static Rank of(int match, boolean bonus) {
        if (match > 6) {
            throw new NoSuchElementException();
        }
        if (match == 5) {
            if (bonus) {
                return SECOND;
            }
            return THIRD;
        }
        return Arrays.stream(Rank.values()).filter(rank -> rank.match == match).findAny().orElse(OUT);
    }
}
