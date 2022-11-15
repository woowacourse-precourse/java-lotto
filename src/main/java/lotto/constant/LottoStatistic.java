package lotto.constant;

public enum LottoStatistic {
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_OF_LOTTERY_NUMBERS(6),
    INITIAL_VALUE(0),
    PROFIT_RATE_MULTIPLIER(100);

    private final int value;

    LottoStatistic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
