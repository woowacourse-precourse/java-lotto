package lotto.model;

import java.util.Arrays;

public enum LottoPrize {
    _1ST_PRIZE(6, 2_000_000_000),
    _2ND_PRIZE(5, 30_000_000),
    _3RD_PRIZE(5, 1_500_000),
    _4TH_PRIZE(4, 50_000),
    _5TH_PRIZE(3, 5_000),
    _NOTHING(0, 0);

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public LottoPrize of(int matchCount, boolean bonusMatch) {
        LottoPrize lottoPrize = getLottoPrize(matchCount);
        return check2ndOr3rd(lottoPrize, bonusMatch);
    }

    private LottoPrize check2ndOr3rd(LottoPrize lottoPrize, boolean bonusMatch) {
        if (lottoPrize == _2ND_PRIZE && !bonusMatch) {
            return _3RD_PRIZE;
        }
        return lottoPrize;
    }

    private LottoPrize getLottoPrize(int matchCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(_NOTHING);
    }
}
