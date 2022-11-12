package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum LottoPrize {
    _1ST_PRIZE(6, 2_000_000_000),
    _2ND_PRIZE(5, 30_000_000),
    _3RD_PRIZE(5, 1_500_000),
    _4TH_PRIZE(4, 50_000),
    _5TH_PRIZE(3, 5_000),
    _NOTHING(0, 0);

    private final Integer match;
    private final Integer prize;

    LottoPrize(Integer match, Integer prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoPrize getEnum(int matchedCount, boolean bonusNumberMatched) {
        LottoPrize lottoPrize = getLottoPrize(matchedCount);
        return checkSecondPrize(lottoPrize, bonusNumberMatched);
    }

    private static LottoPrize getLottoPrize(int matchedCount) {
        return lowestPrizeOrder().stream()
                .filter(prize -> prize.match == matchedCount)
                .findAny()
                .orElse(_NOTHING);
    }

    private static List<LottoPrize> lowestPrizeOrder() {
        return Arrays.stream(values())
                .filter(lottoPrize -> !lottoPrize.equals(_NOTHING))
                .sorted(Comparator.comparingInt(o -> o.prize))
                .collect(toList());
    }

    private static LottoPrize checkSecondPrize(LottoPrize lottoPrize, boolean bonusNumberMatched) {
        if (lottoPrize == _3RD_PRIZE && bonusNumberMatched) {
            return _2ND_PRIZE;
        }
        return lottoPrize;
    }
}
