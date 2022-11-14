package lotto;

public enum Rank {
    THIRD(3, 5_000),
    FORTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(5, 30_000_000),
    SIXTH(6, 2_000_000_000);

    private int sameNumber;
    private int prizeMoney;

    Rank(int sameNumber, int prizeMoney) {
        this.sameNumber = sameNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getSameNumber() {
        return sameNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
