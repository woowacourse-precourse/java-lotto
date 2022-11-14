package lotto.model;

public enum LottoRankingType {
    FIRST_PLACE(6, BonusNumberType.IGNORE),
    SECOND_PLACE(5, BonusNumberType.MATCH),
    THIRD_PLACE(5, BonusNumberType.NOT_MATCH),
    FOURTH_PLACE(4, BonusNumberType.IGNORE),
    FIFTH_PLACE(3, BonusNumberType.IGNORE),
    BANG_TWO_MATCH(2, BonusNumberType.IGNORE),
    BANG_ONE_MATCH(1, BonusNumberType.IGNORE),
    BANG_ZERO_MATCH(0, BonusNumberType.IGNORE);

    private int matchedNumberCount;

    private BonusNumberType bonusNumberType;

    LottoRankingType(int matchedNumberCount, BonusNumberType bonusNumberType) {
        this.matchedNumberCount = matchedNumberCount;
        this.bonusNumberType = bonusNumberType;
    }

    public int getMatchedNumberCount() {
        return this.matchedNumberCount;
    }

    public BonusNumberType getBonusNumberType() {
        return this.bonusNumberType;
    }
}
