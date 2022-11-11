package ui;

public enum PrizeMessage {
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE_NO_BONUS("5개 일치 (1,500,000원) - "),
    FIVE_PLUS_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - ");
    private final String value;

    PrizeMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
