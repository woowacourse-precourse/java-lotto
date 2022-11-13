package lotto;

public enum Rank {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    final private int rank;
    final private long prize;

    public int getRank(){
        return this.rank;
    }
    public long getPrize(){
        return this.prize;
    }

    Rank(int rank, long prize) {
        this.rank = rank;
        this.prize = prize;
    }
}
