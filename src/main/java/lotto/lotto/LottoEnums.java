package lotto.lotto;

public enum LottoEnums {
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_START(1),
    LOTTO_NUMBER_END(45),
    LOTTO_SIZE(6),
    LOTTO_PRIZE_EQ_3(5000),
    LOTTO_PRIZE_EQ_4(50000),
    LOTTO_PRIZE_EQ_5(1500000),
    LOTTO_PRIZE_BONUS(30000000),
    LOTTO_PRIZE_EQ_6(2000000000);


    private final Integer label;

    LottoEnums(Integer label) {
        this.label = label;
    }

    public Integer value() {
        return label;
    }
}
