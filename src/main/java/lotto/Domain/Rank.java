package lotto.Domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    BOTTOM(0, 0);

    private final int matchCount;
    private final int price;

    Rank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Rank findByMatchCount(int num, boolean hasBonusNum) {
        if (num < FIFTH.matchCount) {
            return BOTTOM;
        }
        if (num == THIRD.matchCount && !hasBonusNum) {
            return THIRD;
        }
        if (num == SECOND.matchCount && hasBonusNum) {
            return SECOND;
        }
        return Arrays.stream(Rank.values()).filter(rank -> rank.getMatchCount() == num).findAny().orElse(BOTTOM);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

}
