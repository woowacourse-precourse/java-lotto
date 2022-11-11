package lotto.util;

public enum ResultPrice {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private int price;

    ResultPrice(int price) {

    }

    public int getPrice() {
        return this.price;
    }

}
