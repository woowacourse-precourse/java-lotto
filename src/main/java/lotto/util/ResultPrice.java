package lotto.util;

public enum ResultPrice {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3);

    private final long price;
    private final long match_count;

    ResultPrice(long price, long match_count) {
        this.price = price;
        this.match_count = match_count;
    }

    public long getPrice() {
        return this.price;
    }

    public long getMatch_count() {
        return this.match_count;
    }
}
