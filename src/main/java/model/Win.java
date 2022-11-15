package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Win {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

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

    public static List<Win> getReverseWins() {
        return Arrays.stream(values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
