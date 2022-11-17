package lotto.constant;

public enum LottoPrice {
    THREE_COUNT(3, 5_000)
    , FOUR_COUNT(4, 50_000)
    , FIVE_COUNT(5, 1_500_000)
    , FIVE_COUNT_WITH_BONUS(50, 30_000_000)
    , SIX_COUNT(6, 2_000_000_000);

    private final int number;

    private final int price;

    LottoPrice(int number, int price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }
}
