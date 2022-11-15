package lotto.domain;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int winningCount;
    private final int prizeMoney;

    Rank(int winningCount, int prizeMoney) {
        this.winningCount = winningCount;
        this.prizeMoney = prizeMoney;
    }

    public int winningCount() {
        return winningCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}
