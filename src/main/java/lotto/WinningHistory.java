package lotto;

public enum WinningHistory {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30000000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    BLANK(0, 0);

    private final int matchNumbers;
    private final int prizeMoney;

    WinningHistory(int matchNumbers, int prizeMoney) {
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
