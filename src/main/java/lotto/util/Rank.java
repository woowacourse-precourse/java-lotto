package lotto.util;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    EMPTY(0, 0);

    private final int matchCount;
    private final int price;

    Rank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static Rank fromCount(long count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == count)
                .findFirst()
                .orElseGet(Rank::makeEmpty);
    }

    private static Rank makeEmpty() {
        return EMPTY;
    }
}
