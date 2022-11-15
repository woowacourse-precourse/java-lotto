package lotto.resource;

public enum Constant {
    BEGIN_NUMBER(1),
    END_NUMBER(45),
    REQUIRED_NUMBER_COUNT(6),
    PRICE_PER_LOTTO(1000);

    private final int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
