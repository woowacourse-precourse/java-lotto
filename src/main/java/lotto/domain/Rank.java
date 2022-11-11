package lotto.domain;

public enum Rank {
    ONE(1, 6, 2_000_000_000),
    TWO(2,6,30_000_000),
    THREE(3, 5, 1_500_000),
    FOUR(4, 4, 50_000),
    FIVE(5, 3, 5_000),
    ZERO(0,0,0);

    public static final int LENGTH = 6;
    private final int rank;
    private final int standard;
    private final int money;

    Rank(int rank, int standard, int money) {
        this.rank = rank;
        this.standard = standard;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public boolean isOverStandard(int count) {
        return standard <= count;
    }
}
