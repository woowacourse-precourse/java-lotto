package lotto.model;

public enum Prize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int winningCount;
    private final long prize;

    Prize(int winningCount, long prize) {
        this.winningCount = winningCount;
        this.prize = prize;
    }

    public long getWinningCount() {
        return this.winningCount;
    }

    public long getPrize() {
        return this.prize;
    }
}
