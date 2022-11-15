package lotto.domain;

public enum WinPrize {

    ONE_GRADE(6, 2_000_000_000),
    TWO_GRADE(5, 30_000_000),
    THREE_GRADE(5, 1_500_000),
    FOUR_GRADE(4, 50_000),
    FIVE_GRADE(3, 5_000),
    NOTHING(0, 0);

    private long matchingCount;
    private long price;

    WinPrize(long matchingCount, long price) {
        this.matchingCount = matchingCount;
        this.price = price;
    }

    public long getMatchingCount() {
        return matchingCount;
    }

    public long getPrice() {
        return price;
    }
}
