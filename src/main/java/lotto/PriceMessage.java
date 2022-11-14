package lotto;

public enum PriceMessage {

    RIGHT_THREE(5000 , "3개 일치 (5,000원) - "),
    RIGHT_FOUR(50000 , "4개 일치 (5,0000원) - "),
    RIGHT_FIVE(1500000 , "5개 일치 (1,500,000원) - "),
    RIGHT_FIVE_BONUS(30000000, "5개 일치 , 보너스 볼 일치(30,000,000원) -"),
    RIGHT_ALL(2000000000, "6개 일치 (2,000,000,000원) - ");

    private int price;
    private String message;

    PriceMessage(final int price, final String message) {
        this.price = price;
        this.message = message;
    }
    public int price() {
        return price;
    }
    public String message() {
        return message;
    }
}
