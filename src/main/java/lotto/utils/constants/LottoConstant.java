package lotto.utils.constants;

public enum LottoConstant {

    MIN_LOTTO(1),
    MAX_LOTTO(45),
    LOTTO_SIZE(6),
    LOTTO_AMOUNT_UNIT(1000);

    private final int number;

    LottoConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
