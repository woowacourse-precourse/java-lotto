package lotto.utils;

public enum Rules {
    LOTTO_SIZE(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    SCORE_PER_LOTTO_NUMBER(2),
    SCORE_BONUS_NUMBER(1),
    FIRST_CLASS_COUNT(6),
    SECOND_CLASS_COUNT(5),
    THIRD_CLASS_COUNT(5),
    FIRTH_CLASS_COUNT(4),
    FIFTH_CLASS_COUNT(3),
    PRICE_PER_LOTTO(1000);

    private int value;

    Rules(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
