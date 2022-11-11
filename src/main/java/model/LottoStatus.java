package model;

public enum LottoStatus {
    START(1),
    END(45),
    SIZE(6);

    private final int value;

    LottoStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
