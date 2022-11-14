package model;

import java.util.Arrays;
import java.util.Optional;

public enum Win {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusBall;
    private final int winningAmount;

    Win(int matchCount, boolean bonusBall, int winningAmount) {
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusBall() {
        return bonusBall;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static Optional<Win> getRanking(int matchCount, boolean containsBonusBall) {
        return Arrays.stream(values())
                .filter(win -> isMatch(win, matchCount, containsBonusBall))
                .findAny();
    }

    private static boolean isMatch(Win win, int matchCount, boolean containsBonusBall) {
        if (win.isBonusBall()) {
            return isEqualsMatchCount(win, matchCount) && containsBonusBall;
        }

        return isEqualsMatchCount(win, matchCount);
    }

    private static boolean isEqualsMatchCount(Win win, int matchCount) {
        return win.matchCount == matchCount;
    }
}
