package lotto;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    LOSER(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

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

    public int getWinMoney() {
        return this.winMoney;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean isSecond() {
        return this.winMoney == SECOND.getWinMoney();
    }
}