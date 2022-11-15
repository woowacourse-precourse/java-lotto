package lotto;

public enum Rank {
    FIRST(0, 6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(1, 7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(2, 5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(3, 4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(4, 3, 5000, "3개 일치 (5,000원) - "),
    NONE(5, 0, 0, "");

    private final int value;
    private final int count;
    private final int price;
    private final String printing;

    Rank(int value, int count, int price, String printing) {
        this.value = value;
        this.count = count;
        this.price = price;
        this.printing = printing;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getPrinting() {
        return printing;
    }
}
