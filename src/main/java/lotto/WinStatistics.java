package lotto;

public enum WinStatistics {

    UNSUCCESSFUL(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int prizeMoney;

    WinStatistics(final int matchCount, final int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }
}
