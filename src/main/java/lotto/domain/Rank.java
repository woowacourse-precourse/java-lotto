package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0);

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Rank getRank(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
