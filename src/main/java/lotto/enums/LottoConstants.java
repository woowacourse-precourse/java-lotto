package lotto.enums;

public enum LottoConstants {
    LOTTO_NUMBERS_LENGTH(6),
    MIN_LOTTO_NUMBER_RANGE(1),
    MAX_LOTTO_NUMBER_RANGE(45),
    LOTTO_RANKING_RANGE(5),
    LOTTO_PRICE(1000);



    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
