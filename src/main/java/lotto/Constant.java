package lotto;

public enum Constant {
    LOTTO_PRICE(1000),
    LOTTO_RANGE_START(1),
    LOTTO_RANGE_END(45),
    LOTTO_NUMBER_CNT(6),
    LOTTO_BONUS_CNT(1);

    final private int num;

    Constant(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}