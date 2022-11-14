package lotto.view;

public enum WinningPrice {
    FIRST_PRICE(2000000000),
    SECOND_PRICE(30000000),
    THIRD_PRICE(1500000),
    FOURTH_PRICE(50000),
    FIFTH_PRICE(5000);

    private final int winPrice;

    WinningPrice(int winPrice) {
        this.winPrice = winPrice;
    }

    public int getWinPrice() {
        return winPrice;
    }
}
