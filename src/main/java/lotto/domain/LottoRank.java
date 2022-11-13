package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4 , 50_000),
    FIFTH(3, 5_000);

    private int matchNumber;
    private int profit;

    LottoRank(int matchNumber, int profit) {
        this.profit = profit;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public int getProfit() {
        return this.profit;
    }
}
