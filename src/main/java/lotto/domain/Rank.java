package lotto.domain;

public enum Rank {
    Fifth_Place(3, 5000,false),
    Fourth_Place(4, 50000,false),
    Third_Place(5, 1500000,false),
    Second_Place(5, 30000000,true),
    First_Place(6, 2000000000,false);
    private final int counts;
    private final int price;

    public boolean isBonus() {
        return bonus;
    }

    private final boolean bonus;

    Rank(int counts, int price, boolean bonus ) {
        this.counts = counts;
        this.price = price;
        this.bonus =bonus;
    }

    public int getPrice() {
        return price;
    }

    public int getCounts() {
        return counts;
    }
}
