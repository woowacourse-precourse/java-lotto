package lotto.model;

public enum LottoRankingType {
    FIRST_PLACE(6, BonusNumberType.IGNORE, 2000000000),
    SECOND_PLACE(5, BonusNumberType.MATCH, 30000000),
    THIRD_PLACE(5, BonusNumberType.NOT_MATCH, 1500000),
    FOURTH_PLACE(4, BonusNumberType.IGNORE, 50000),
    FIFTH_PLACE(3, BonusNumberType.IGNORE, 5000),
    BANG(0, BonusNumberType.IGNORE, 0);

    private int matchedNumberCount;

    private BonusNumberType bonusNumberType;

    private int winningAmount;

    LottoRankingType(int matchedNumberCount, BonusNumberType bonusNumberType, int winningAmount) {
        this.matchedNumberCount = matchedNumberCount;
        this.bonusNumberType = bonusNumberType;
        this.winningAmount = winningAmount;
    }

    public int getMatchedNumberCount() {
        return this.matchedNumberCount;
    }

    public BonusNumberType getBonusNumberType() {
        return this.bonusNumberType;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }
}
