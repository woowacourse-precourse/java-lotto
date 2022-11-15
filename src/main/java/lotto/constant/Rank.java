package lotto.constant;

import java.util.Arrays;

import lotto.domain.Money;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(2, 0);

    private final int matchCount;
    private final Money prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = new Money(prize);
    }

    public static Rank from(int matchCount, boolean hasBonusNumber) {
        if (isThird(matchCount, hasBonusNumber)) {
            return THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isThird(int matchCount, boolean hasBonusNumber) {
        return matchCount == THIRD.matchCount && !hasBonusNumber;
    }

    public boolean hasBonusNumber() {
        return this == SECOND;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrize() {
        return prize;
    }
}
