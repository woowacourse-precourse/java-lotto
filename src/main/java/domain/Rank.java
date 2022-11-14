package domain;

public enum Rank {
    FIRST(6),
    SECOND(6),
    THIRD(5),
    FOURTH(4),
    FIFTH(3);

    private final int winningCount;

    Rank(int winningCount) {
        this.winningCount = winningCount;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
