package lottoMachine.enums;

public enum Numbers {
    ZERO(0),
    LOTTO_NUMBER_START(1),
    LOTTO_NUMBER_END(45),
    LOTTO_PRICE(1000),
    WINNING_NUMBER_SIZE(6),
    BONUS_NUMBER_SIZE(1),
    LOTTO_PRICE_MIN(1000),
    LOTTO_PRICE_MAX(2_147_483_000),
    KINDS_OF_PRIZE(5);

    private final int value;

    Numbers(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }
}
