package lotto;

public enum price {
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_BONUS(3_000_000),
    SIX(2_000_000_000);

    private int priceMoney;

    price(int priceMoney) {
        this.priceMoney = priceMoney;
    }

    public int getPriceMoney() {
        return priceMoney;
    }
}
