package lotto;

public enum Constant {
    LOTTO_SIZE(6),
    LOTTO_STANDARD(1000),
    LOTTO_VALUE_5000(5000),
    LOTTO_VALUE_50000(50000),
    LOTTO_VALUE_1500000(1500000),
    LOTTO_VALUE_30000000(30000000),
    LOTTO_VALUE_2000000000(2000000000);

    final private int num;

    Constant(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
