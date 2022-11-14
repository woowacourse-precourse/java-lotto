package lotto;

public enum LottoEnums {
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_START(1),
    LOTTO_NUMBER_END(45),
    LOTTO_SIZE(6);

    private final Integer label;

    LottoEnums(Integer label) {
        this.label = label;
    }

    public Integer value() {
        return label;
    }
}
