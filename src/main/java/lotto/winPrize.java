package lotto;
public enum winPrize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    WIN(6, 2000000000);

    public final int count;
    public final int prize;

    winPrize(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }
}