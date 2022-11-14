package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FAIL(0, false, 0),
    RANK5(3, false, 5_000),
    RANK4(4, false, 50_000),
    RANK3(5, false, 1_500_000),
    RANK2(5, true, 30_000_000),
    RANK1(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int price;

    Rank(final int matchCount, final boolean isBonusMatch, final int price) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.price = price;
    }

    public static Rank of(final int matchCount, final boolean isBonusMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.isSameMatchCount(matchCount))
            .filter(rank -> !rank.equals(RANK2) || isBonusMatch)
            .findAny()
            .orElse(FAIL);
    }

    private boolean isSameMatchCount(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
    
    public int getPrice() {
        return this.price;
    }
}
