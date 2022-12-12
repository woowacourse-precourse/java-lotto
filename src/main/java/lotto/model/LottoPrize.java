package lotto.model;

public enum LottoPrize {
    _1ST_PRIZE(6, 2_000_000_000),
    _2nd_PRIZE(5, 30_000_000),
    _3rd_PRIZE(5, 1_500_000),
    _4th_PRIZE(4, 50_000),
    _5th_PRIZE(3, 5_000),
    nothing(0, 0);

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
}
