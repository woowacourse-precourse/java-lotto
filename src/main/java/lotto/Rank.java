package lotto;

public enum Rank {
    THIRD(6, 5_000),
    FORTH(5, 50_000),
    FIFTH(3, 1_500_000),
    FIFTH_BONUS(3, 30_000_000),
    SIXTH(3, 2_000_000_000);

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
