package lotto.enums;

public enum Numbers {
    LOTTO_NUMBER_START(1),
    LOTTO_NUMBER_END(45),
    LOTTO_PRICE(1000),
    WINNING_NUMBER_SIZE(6),
    BONUS_NUMBER_SIZE(1);

    private final int value;

    Numbers(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }
}
