package lotto.domain.enums;

public enum Constant {
    LOTTO_SIZE(3),
    FIFTH_WINNING_AMOUNT(5_000),
    FOURTH_WINNING_AMOUNT(50_000),
    THIRD_WINNING_AMOUNT(1_500_000),
    SECOND_WINNING_AMOUNT(30_000_000),
    FIRST_WINNING_AMOUNT(2_000_000_000);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
