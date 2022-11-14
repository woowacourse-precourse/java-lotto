package lotto;

public enum Rank {
    THIRD(3, 5_000, 0),
    FORTH(4, 50_000, 0),
    FIFTH(5, 1_500_000, 0),
    FIFTH_BONUS(5, 30_000_000, 0),
    SIXTH(6, 2_000_000_000, 0);

    private int sameNumber;
    private int prizeMoney;
    private int count;

    Rank(int sameNumber, int prizeMoney, int count) {
        this.sameNumber = sameNumber;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public int getSameNumber() {
        return sameNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount(){
        count++;
    }
}
