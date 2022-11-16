package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    MISS(0, 0);

    private final int winningMoney;
    private final int countOfMatches;

    Rank(int winningMoney, int countOfMatches) {
        this.winningMoney = winningMoney;
        this.countOfMatches = countOfMatches;
    }

    public static Rank of(int countOfMatches, boolean containsBonusNumber) {
        if (isSecondOrThirdPlace(countOfMatches)) {
            if (containsBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        return getResultByMatchingCount(countOfMatches);
    }

    private static boolean isSecondOrThirdPlace(int matchingCount) {
        return matchingCount == SECOND.getCountOfMatches();
    }

    private static Rank getResultByMatchingCount(int matchingCount) {
        Rank[] results = values();
        return Arrays.stream(results)
                .filter(result -> result.hasSameMatchingCount(matchingCount))
                .findFirst()
                .orElse(MISS);
    }

    private boolean hasSameMatchingCount(int matchingCount) {
        return this.countOfMatches == matchingCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatches() {
        return countOfMatches;
    }

    public boolean win() {
        return countOfMatches >= FIFTH.getCountOfMatches();
    }
}
