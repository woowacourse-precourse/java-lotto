package lotto.type;

public enum LottoInformation {
    SIZE(6),
    START(1),
    END(45),
    SMALLEST_UNIT(1000);
    private final int value;

    LottoInformation(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
