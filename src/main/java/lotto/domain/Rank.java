package lotto.domain;

public enum Rank {
    FIRST(6, new Money(2000000000)),
    SECOND(5, new Money(30000000)),
    THIRD(5, new Money(1500000)),
    FOURTH(4, new Money(50000)),
    FIFTH(3, new Money(5000)),
    OUT(0, new Money(0));


    private final int match;
    private final Money price;

    Rank(int match, Money price) {
        this.match = match;
        this.price = price;
    }

    public Money getPrice() {
        return this.price;
    }

    public int getMatch() {
        return this.match;
    }
}
