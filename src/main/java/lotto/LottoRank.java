package lotto;

public enum LottoRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    LOSE(0);

    private final int winPrice;

    LottoRank(int winPrice) {
        this.winPrice = winPrice;
    }

    public int getWinPrice() {
        return this.winPrice;
    }
}
