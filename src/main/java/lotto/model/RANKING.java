package lotto.model;

public enum RANKING {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(2, 0);

    private final int countBall;
    private final long price;

    RANKING(final int countBall, final long price) {
        this.countBall = countBall;
        this.price = price;
    }

    public int getCountBall() {
        return countBall;
    }

    public long getPrice() {
        return price;
    }
}
