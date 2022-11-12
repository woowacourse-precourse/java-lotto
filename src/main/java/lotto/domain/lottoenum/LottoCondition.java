package lotto.domain.lottoenum;

public enum LottoCondition {
    MIN(1),
    MAX(45),
    LENGTH(6);

    private final int value;

    LottoCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
