package lotto.situation;

public enum LottoState {
    START(1),
    END(45),
    RANGE(END.value - START.value + 1),
    LENGTH(6);
    private final int value;
    LottoState(int value) {
        this.value = value;
    }
    public int number() {
        return this.value;
    }
}
