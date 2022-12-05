package lotto.util;

public enum NumericProperties {
    SIZE(6),
    MIN_NUM(1),
    MAX_NUM(45),
    ONE_THOUSAND(1000);

    private final int value;

    NumericProperties(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
