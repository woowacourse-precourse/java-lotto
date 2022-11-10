package lotto.constant;

public enum IntConstant {
    LOTTO_MONEY_PER_ONE(1000);

    private int value;

    IntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
