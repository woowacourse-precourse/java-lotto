package model;

public enum LottoStatus {
    START(1),
    END(45),
    SIZE(6),
    LIMIT(1),
    PRICE(1000);

    private final int value;

    LottoStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
