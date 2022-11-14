package lotto.domain;

public enum LottoConstant {
    SIZE(6),
    STARTFROM(1),
    ENDTO(45),
    PRICE(1000);

    private int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
