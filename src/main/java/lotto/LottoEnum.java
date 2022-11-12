package lotto;

public enum LottoEnum {
    MIN_NUMBER(1), MAX_NUMBER(45), WINNING_NUMBERS(6), BONUS_NUMBERS(1),
    PURCHASE_UNIT(1000),
    MATCH_THREE_PRIZE(5_000), MATCH_FOUR_PRIZE(50_000), MATCH_FIVE_PRIZE(1_500_000), MATCH_FIVE_WITH_BONUS_PRIZE(30_000_000), MATCH_SIX_PRIZE(2_000_000_000);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
