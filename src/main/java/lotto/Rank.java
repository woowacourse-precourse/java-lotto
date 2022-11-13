package lotto;

public enum Rank {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);

    private final int prize;

    public int getPrize() {
        return prize;
    }

    private Rank(int prize) {
        this.prize = prize;
    }
}
