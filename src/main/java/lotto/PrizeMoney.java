package lotto;

public enum PrizeMoney {
    FIVE(5_000),
    FOUR(50_000),
    THREE(1_500000),
    TWO(30_000000),
    ONE(2_000000000);

    final private int PrizeMoney;

    public int getPrizeMoney() {
        return PrizeMoney;
    }

    PrizeMoney(int prizeMoney) {
        this.PrizeMoney = prizeMoney;
    }
}
