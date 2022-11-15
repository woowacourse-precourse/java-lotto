package lotto.enums;

public enum LottoCondition {
    PRICE_UNIT(1000),
    BOUND_START(1),
    BOUND_END(45),
    BOUND_SIZE(6);

    private final int number;

    LottoCondition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
