package lotto.entity;

public enum LottoConstant {

    COUNT(6),
    RANGE_START(1),
    RANGE_END(45),
    PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
