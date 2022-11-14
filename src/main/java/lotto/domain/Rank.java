package lotto.domain;

public enum Rank {
    First_Place(2000000000),
    Second_Place(30000000),
    Third_Place(1500000),
    Fourth_Place(50000),
    Fifth_Place(5000);
    private int price;
    Rank(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
