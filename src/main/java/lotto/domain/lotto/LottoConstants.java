package lotto.domain.lotto;

public enum LottoConstants {
    PRICE_UNIT(1000),
    LOTTO_MIN_VALUE(1),
    LOTTO_MAX_VALUE(45),
    LOTTO_SIZE(6);

    private final int number;

    LottoConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
