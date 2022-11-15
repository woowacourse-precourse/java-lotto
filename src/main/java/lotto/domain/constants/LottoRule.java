package lotto.domain.constants;

public enum LottoRule {
    PRICE(1_000),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    NUMBERS_COUNT(6);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
