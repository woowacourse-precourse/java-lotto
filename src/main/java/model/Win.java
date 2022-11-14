package model;

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

    public boolean isEqualsMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
