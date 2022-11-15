package lotto;

public enum PriceMessage {

    RIGHT_THREE("3개 일치 (5,000원) - "),
    RIGHT_FOUR("4개 일치 (50,000원) - "),
    RIGHT_FIVE("5개 일치 (1,500,000원) - "),
    RIGHT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RIGHT_ALL("6개 일치 (2,000,000,000원) - ");

    private String message;

    PriceMessage(final String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
