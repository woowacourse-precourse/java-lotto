package lotto.Enum;

public enum LottoProperty {
    ONE_LOTTO_COST (1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_LENGTH(6),
    LOWEST_WINNING_RANK(5),
    HIGHEST_WINNING_RANK(1);

    // TODO: 등수별 금액 설정

    private int property;

    private LottoProperty(final int property) {
        this.property = property;
    }

    public int getValue() {
        return property;
    }
}
