package lotto.domain;

public enum Rank {
    Fifth_Place(3, 5000),
    Fourth_Place(4, 50000),
    Third_Place(5, 1500000),
    Second_Place(5, 30000000),
    First_Place(6, 2000000000);
    private int counts;
    private int price;

    Rank(int counts, int price) {
        this.counts = counts;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getCounts() {
        return counts;
    }
}
