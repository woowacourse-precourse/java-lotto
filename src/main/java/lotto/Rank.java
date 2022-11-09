package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int numberOfRight;
    private final int prizeMoney;
    private Rank(int numberOfRight, int prizeMoney) {
        this.numberOfRight = numberOfRight;
        this.prizeMoney = prizeMoney;
    }
}
