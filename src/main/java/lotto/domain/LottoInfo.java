package lotto.domain;

public enum LottoInfo {

    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private int value;

    LottoInfo(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
