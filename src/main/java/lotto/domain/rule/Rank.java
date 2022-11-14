package lotto.domain.rule;

import java.util.Arrays;

public enum Rank {
    FIRST(1, 6, false, 2_000_000_000),
    SECOND(2, 5, true, 30_000_000),
    THIRD(3, 5, false, 1_500_000),
    FOURTH(4, 4, false, 50_000),
    FIFTH(5, 3, false, 5_000),
    FAIL(-1, -1, false, 0);

    private final int rank;
    private final int matchingCount;
    private final boolean hasBonusNumber;
    private final int winnings;

    Rank(int rank, int matchedNumber, boolean hasBonusNumber, int winnings) {
        this.rank = rank;
        this.matchingCount = matchedNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.winnings = winnings;
    }

    public static Rank getRank(int matchedNumber, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank1 -> rankConditionFilter(rank1, matchedNumber, hasBonusNumber))
                .findAny()
                .orElse(Rank.FAIL);
    }

    private static boolean rankConditionFilter(Rank rank, int matchedNumber, boolean hasBonusNumber) {
        return rank.matchingCount == matchedNumber &&
                (!rank.hasBonusNumber || hasBonusNumber);
    }

    public int getRank() {
        return rank;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getWinnings() {
        return winnings;
    }
}
