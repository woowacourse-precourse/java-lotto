package lotto.domain;

public enum Rank {
    WIN5(3, "5,000"),
    WIN4(4, "50,000"),
    WIN3(5, "1,500,000"),
    WIN2(5, "30,000,000"),
    WIN1(6, "2,000,000,000");


    private final int count;
    private final String price;

    Rank(int count, String price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public String getPrice() {
        return price;
    }
}
