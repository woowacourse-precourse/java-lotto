package lotto;

public enum LottoRange {
    NUMBER_MIN(1),
    NUMBER_MAX(45),
    LOTTERY_MAX(6),
    WINING_RANK(5);

    private final int value;

    LottoRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
