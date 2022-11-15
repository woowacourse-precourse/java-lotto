package lotto.domain;

public enum Rank {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(30_000_000)),
    THIRD(5, new Money(1_500_000)),
    FOURTH(4, new Money(50_000)),
    FIFTH(3, new Money(5_000)),
    NOTHING(0, new Money(0));

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
