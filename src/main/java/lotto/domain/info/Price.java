package lotto.domain.info;

public enum Price {
    SINGLE_PRICE(1000);

    private final int price;

    Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
