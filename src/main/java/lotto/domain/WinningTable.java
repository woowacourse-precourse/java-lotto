package lotto.domain;

public enum WinningTable {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    LOSE(0);

    int price;

    WinningTable(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
