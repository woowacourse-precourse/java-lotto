package lotto.constants;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int win;
    private final int price;

    private Prize(int win, int price) {
        this.win = win;
        this.price = price;
    }

    public int getWin() {
        return win;
    }

    public int getPrice() {
        return price;
    }
}