package lotto.price;

public enum PrizeMoney {
    PRIZE_MONEY_FIFTH(5000),
    PRIZE_MONEY_FOURTH(50000),
    PRIZE_MONEY_THIRD(1500000),
    PRIZE_MONEY_SECOND(30000000),
    PRIZE_MONEY_FIRST(2000000000);
    private final int value;

    PrizeMoney(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
