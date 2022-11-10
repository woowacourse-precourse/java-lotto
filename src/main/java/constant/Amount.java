package constant;

public enum Amount {
    UNIT(1_000),
    MATCH_THREE(5_000),
    MATCH_FOUR(50_000),
    MATCH_FIVE(1_500_000),
    MATCH_FIVE_AND_BONUS(30_000_000),
    MATCH_ALL(2_000_000_000),
    ;
    private final int price;

    Amount(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return Integer.toString(price);
    }
}
