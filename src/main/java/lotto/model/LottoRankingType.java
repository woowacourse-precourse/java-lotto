package lotto.model;

public enum LottoRankingType {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    BANG(0, 0);
    private int matchedNumberCount;

    private int winningAmount;

    LottoRankingType(int matchedNumberCount, int winningAmount) {
        this.matchedNumberCount = matchedNumberCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchedNumberCount() {
        return this.matchedNumberCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }
}
