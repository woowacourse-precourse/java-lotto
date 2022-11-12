package lotto;

public enum WinPrize {

    ONE_GRADE(6, 2_000_000_000),
    TWO_GRADE(5, 30_000_000),
    THREE_GRADE(5, 1_500_000),
    FOUR_GRADE(4, 50_000),
    FIVE_GRADE(3, 5_000),
    NOTHING(0, 0);

    long matchCount;
    long price;

    WinPrize(long matchCount, long price) {
        this.matchCount = matchCount;
        this.price = price;
    }
}
