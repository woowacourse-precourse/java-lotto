package lotto.Rank;

public enum Rank {
    THIRD(3, 5_000,0),
    FORTH(4, 50_000,0),
    FIFTH(5, 1_500_000,0),
    FIFTH_BONUS(5, 30_000_000,0),
    SIXTH(6, 2_000_000_000,0);

    private int count;
    private int prizeMoney;
    private int rank;
    Rank(int rank, int prizeMoney, int count) {
        this.rank = rank;
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
    public void increase() {
        count++;
    }
}

