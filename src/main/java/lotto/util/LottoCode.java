package lotto.util;

public enum LottoCode {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    COUNT_LOTTO_NUMBER(6),
    COUNT_BONUS_NUMBER(1),
    LOTTO_PRICE(1000);

    private final int code;

    LottoCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
