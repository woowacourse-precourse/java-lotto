package lotto.domain;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD( 1500000),
    FOURTH( 50000),
    FIFTH( 5000),
    UNIT(1000),
    LOTTO_LEN(6),
    LOTTO_MAX_SIZE(45),
    LOTTO_MIN_SIZE(1);

    private final long value;

    Rank(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }
}
