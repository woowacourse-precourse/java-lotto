package lotto.domain;

public enum LottoInfo {
    MAX_NUMBER(45), MIN_NUMBER(1), LOTTO_PRICE(1000), LOTTO_LENGTH(6);
    private final int value;
    LottoInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
