package lotto.constants;

public enum LottoStandard {
    NUMBER_START(1),
    NUMBER_END(45),
    SIZE(6);

    final int value;

    LottoStandard(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
