package lotto.Enum;

public enum LottoProperty {
    ONE_LOTTO_COST(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_LENGTH(6),
    LOWEST_WINNING_RANK(5),
    HIGHEST_WINNING_RANK(1),
    RANK5_WINNING_MONEY(5000),
    RANK4_WINNING_MONEY(50000),
    RANK3_WINNING_MONEY(1500000),
    RANK2_WINNING_MONEY(30000000),
    RANK1_WINNING_MONEY(2000000000);

    private final int property;

    LottoProperty(final int property) {
        this.property = property;
    }

    public int getValue() {
        return property;
    }
}
