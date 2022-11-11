package lotto.domain.wrapper;

public enum Rank {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private final int prize;
    Rank(int prize) {
        this.prize = prize;
    }

    public int currentPrize() {
        return this.prize;
    }
}
