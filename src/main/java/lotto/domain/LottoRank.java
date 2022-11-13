package lotto.domain;

public enum LottoRank {
    FIRST(6, false,  2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BLANK(-1, false, 0);

    private int matchNumber;
    private boolean bonusNumber;
    private int profit;

    LottoRank(int matchNumber, boolean bonusNumber, int profit) {
        this.matchNumber = matchNumber;
        this.bonusNumber = bonusNumber;
        this.profit = profit;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public boolean getBonusNumber() {
        return this.bonusNumber;
    }

    public int getProfit() {
        return this.profit;
    }
}
