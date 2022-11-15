package lotto;

public enum GameVariable {
    LOTTO_PRICE(1000),
    MIN(1),
    MAX(45),
    NUMBER_SIZE(6),
    HIT_THREE(5000),
    HIT_FOUR(50000),
    HIT_FIVE(1500000),
    HIT_FIVE_BONUS(30000000),
    HIT_SIX(2000000000);

    private final int value;

    GameVariable(int value) {
        this.value = value;
    }
}
