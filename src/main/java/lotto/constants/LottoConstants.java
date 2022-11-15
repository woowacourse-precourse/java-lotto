package lotto.constants;

public enum LottoConstants {
    LOTTO_NUMBERS_LENGTH(6),
    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    LOTTO_RANKING_RANGE(5),
    LOTTO_PRICE(1000),
    FIRST_RANK(1),
    SECOND_RANK(2),
    THIRD_RANK(3),
    FOURTH_RANK(4),
    FIFTH_RANK(5);



    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
