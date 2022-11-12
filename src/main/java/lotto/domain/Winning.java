package lotto.domain;

public enum Winning {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);

    int price;

    Winning(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
