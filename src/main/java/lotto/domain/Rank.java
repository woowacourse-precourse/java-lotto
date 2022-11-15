package lotto.domain;

public enum Rank {
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ");
    private final int index;
    private final int winningsPrice;
    private final String text;

    private Rank(int index, int winningsPrice, String text) {
        this.index = index;
        this.winningsPrice = winningsPrice;
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public int getWinningsPrice() {
        return winningsPrice;
    }

    public String getText() {
        return text;
    }
}
