package lotto.domain;

public enum Rank {
    FIRST(6, new Money(2000000000)),
    SECOND(5, new Money(30000000)),
    THIRD(5, new Money(1500000)),
    FOURTH(4, new Money(50000)),
    FIFTH(3, new Money(5000)),
    OUT(0, new Money(0));


    private final int match;
    private final Money prize;

    Rank(int match, Money prize) {
        this.match = match;
        this.prize = prize;
    }

    public Money getPrize() {
        return this.prize;
    }

    public int getMatch() {
        return this.match;
    }
}
