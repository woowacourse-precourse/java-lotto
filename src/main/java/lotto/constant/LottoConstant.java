package lotto.constant;

public enum LottoConstant {
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_BONUS_NUMBER_COUNT(1),
    LEAST_REWARD_NUMBER_COUNT(3),
    PRICE(1000),
    PERCENTAGE(100);
    private final int number;

    LottoConstant(int number) {
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }
}
