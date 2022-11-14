package lotto;

public enum WinningReward {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int price;

    WinningReward(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
