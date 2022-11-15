package lotto.model.lotto;

public enum Rank {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FORTH(50_000, 4),
    FIFTH(5_000, 3),
    FAIL(0, 0);

    private final int prizeMoney;
    private final int cntOfSameNumber;

    Rank(int prizeMoney, int cntOfSameNumber) {
        this.prizeMoney = prizeMoney;
        this.cntOfSameNumber = cntOfSameNumber;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getCntOfSameNumber() {
        return this.cntOfSameNumber;
    }
}