package lotto.domain;

public enum WinningPrice {
   FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int price;

    WinningPrice(final int price) {
       this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
