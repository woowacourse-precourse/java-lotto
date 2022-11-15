package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0, false),
    FiFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prize;
    private final int matchCount;
    private final boolean isBonus;

    Rank(final int prize, final int matchCount, boolean isBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public static Rank findRank(int matchCount, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> checkMatchCountAndBonus(rank, matchCount, isBonus))
                .findAny()
                .orElse(NONE);
    }

    private static boolean checkMatchCountAndBonus(Rank rank, int matchCount, boolean isBonus) {
        if (rank.getMatchCount() != matchCount) {
            return false;
        }
        if (SECOND.getMatchCount() == matchCount) {
            return rank.getBonus() == isBonus;
        }
        return true;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public boolean getBonus() {
        return this.isBonus;
    }
}