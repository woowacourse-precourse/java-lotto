package lotto;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    final public int prize;
    final public int numberOfLucky;

    public Integer getPrize() {
        return prize;
    }

    public Integer getNumOfLucky() {
        return numberOfLucky;
    }

    Prize(int numberOfLucky, int prize) {
        this.numberOfLucky = numberOfLucky;
        this.prize = prize;
    }
}