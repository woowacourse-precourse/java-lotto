package lotto.util;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    EMPTY(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int price;

    Rank(int matchCount, boolean matchBonus, int price) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Rank fromCount(long count, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> {
                    if (count == 5) {
                        return rank.matchCount == count && rank.matchBonus == matchBonus;
                    }

                    return rank.matchCount == count;
                })
                .findFirst()
                .orElseGet(Rank::makeEmpty);
    }

    private static Rank makeEmpty() {
        return EMPTY;
    }
}
