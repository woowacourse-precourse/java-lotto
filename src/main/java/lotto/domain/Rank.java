package lotto.domain;

public enum Rank {

    FIVE(5, 3, 5_000, "3개 일치 (5,000원) - "),
    FOUR(4, 4, 50_000, "4개 일치 (50,000원) - "),
    THREE(3, 5, 1_500_000, "5개 일치 (1,500,000원) - "),
    TWO(2, 6, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ONE(1, 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    ZERO(0, 0, 0, "");

    public static final int LENGTH = 6;
    private final int rank;
    private final int standard;
    private final int money;
    private final String message;

    Rank(int rank, int standard, int money, String message) {
        this.rank = rank;
        this.standard = standard;
        this.money = money;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public boolean isOverStandard(int count) {
        return standard <= count;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return message;
    }
}
