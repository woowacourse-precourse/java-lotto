package common.regulation;

public enum NumberRule {

    LOTTO_ONE_PRICE(1000),
    LOTTO_ONE_SIZE(6),
    NUMBER_RANGE_START(1),
    NUMBER_RANGE_END(45);

    private final int value;

    NumberRule(int value) {
        this.value = value;
    }

    public String getName() {
        return name();
    }

    public int getValue() {
        return value;
    }
}
