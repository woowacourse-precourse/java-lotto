package lotto.domain;

public enum WinningRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NOTHING(0);

    private final int price;

    private WinningRank(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
