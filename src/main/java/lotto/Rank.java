package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSER(0, false, 0);

    private final int matchCount;
    private final boolean isBonus;
    private final int winMoney;

    Rank(int matchCount, boolean isBonus, int winMoney) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.winMoney = winMoney;
    }

    public static Rank of(int matchCount, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(matchCount, isBonus))
                .findFirst()
                .orElse(LOSER);
    }

    private boolean isMatch(int matchCount, boolean isBonus) {
        if (this.matchCount == matchCount) {
            return checkBonus(isBonus);
        }
        return false;
    }

    private boolean checkBonus(boolean isBonus) {
        if (this.isBonus == isBonus) {
            return true;
        }
        return false;
    }
}
