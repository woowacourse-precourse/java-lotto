package lotto.domain;

public enum LottoPrize {
    _1ST_PRIZE(6, 2_000_000_000),
    _2ND_PRIZE(5, 30_000_000),
    _3RD_PRIZE(5, 1_500_000),
    _4TH_PRIZE(4, 50_000),
    _5TH_PRIZE(3, 5_000);

    private final Integer match;
    private final Integer prize;

    LottoPrize(Integer match, Integer prize) {
        this.match = match;
        this.prize = prize;
    }
}
