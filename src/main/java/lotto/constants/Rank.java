package lotto.constants;

public enum Rank {
    FIRST(6, 2000000000,4),
    SECOND(5, 30000000,3),
    THIRD(5, 1500000,2),
    FOURTH(4, 50000,1),
    FIFTH(3, 5000,0),
    REST(0,0,5);

    private final int win;
    private final int price;
    private final int index;

    Rank(int win, int price, int index) {
        this.win = win;
        this.price = price;
        this.index = index;
    }

    public int getWin() {
        return win;
    }

    public int getPrice() {
        return price;
    }

    public int getIndex() {
        return index;
    }
}