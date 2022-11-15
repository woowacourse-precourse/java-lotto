package lotto;

public enum Prize {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    NOTHING(0, 0, 0);

    final public int rank;
    final public int prize;
    final public int numberOfLucky;

    public Integer getPrize() {
        return prize;
    }

    public Integer getNumOfLucky() {
        return numberOfLucky;
    }

    public Integer getRank(){
        return rank;
    }

    Prize(int rank, int numberOfLucky, int prize) {
        this.rank = rank;
        this.numberOfLucky = numberOfLucky;
        this.prize = prize;
    }
}