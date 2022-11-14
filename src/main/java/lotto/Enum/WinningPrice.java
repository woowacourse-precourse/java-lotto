package lotto.Enum;

public enum WinningPrice {
    RANK5_WINNING_PRICE(5000,"5,000원"),
    RANK4_WINNING_PRICE(50000,"50,000원"),
    RANK3_WINNING_PRICE(1500000,"1,500,000원"),
    RANK2_WINNING_PRICE(30000000,"30,000,000원"),
    RANK1_WINNING_PRICE(200000000,"2,000,000,000원");

    private final int price;
    private final String stringPrice;
    private WinningPrice(final int price, final String stringPrice) {
        this.price = price;
        this.stringPrice = stringPrice;
    }

    public int getPrice() {
        return price;
    }

    public String getStringPrice(){return stringPrice;}

}
