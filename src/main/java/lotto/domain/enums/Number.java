package lotto.domain.enums;

public enum Number {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), THOUSAND(1000),
    LOTTO_SIZE(6),
    FIFTH_WINNING_AMOUNT(5_000),
    FOURTH_WINNING_AMOUNT(50_000),
    THIRD_WINNING_AMOUNT(1_500_000),
    SECOND_WINNING_AMOUNT(30_000_000),
    FIRST_WINNING_AMOUNT(2_000_000_000);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
