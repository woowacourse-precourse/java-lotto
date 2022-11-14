package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public final class LottoScoreDto {
    private static final String NULL_MESSAGE = "prizeCount 에 null 이 포함되어 있습니다";
    private final Map<LottoPrize, Integer> prizeCount;
    private final double rate;

    public LottoScoreDto(Map<LottoPrize, Integer> prizeCount, double rate) {
        validate(prizeCount);
        this.prizeCount = prizeCount;
        this.rate = rate;
    }

    private void validate(Map<LottoPrize, Integer> prizeCount) {
        if (isNull(prizeCount)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        if (containsNull(prizeCount)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }


    private boolean isNull(Map<LottoPrize, Integer> prizeCount) {
        return prizeCount == null;
    }

    private boolean containsNull(Map<LottoPrize, Integer> prizeCount) {
        return Arrays.stream(LottoPrize.values())
                .anyMatch(prize -> prizeCount.get(prize) == null);
    }

    public int fifthPrizeCount() {
        return prizeCount.get(LottoPrize.FIFTH_PRIZE);
    }

    public int fourthPrizeCount() {
        return prizeCount.get(LottoPrize.FOURTH_PRIZE);
    }

    public int thirdPrizeCount() {
        return prizeCount.get(LottoPrize.THIRD_PRIZE);
    }

    public int secondPrizeCount() {
        return prizeCount.get(LottoPrize.SECOND_PRIZE);
    }

    public int firstPrizeCount() {
        return prizeCount.get(LottoPrize.FIRST_PRIZE);
    }

    public double getRate() {
        return rate;
    }
}
