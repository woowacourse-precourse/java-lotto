package lotto.domain;

public enum Win {
    FIND(1, 0),
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    FIFTH_WITH_BONUS(7, 30000000),
    SIXTH(6, 2000000000);

    private final int label;
    private final int price;

    Win(int label, int price) {
        this.label = label;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Win valueOf(int label) {
        for (Win win : Win.values()) {
            if (label == win.label) {
                return win;
            }
        }
        return null;
    }
}