package lotto.domain;

import java.util.Map;

public final class LottoScoreDto {
    private final Map<LottoPrize, Integer> prizeCount;
    private final double rate;

    public LottoScoreDto(Map<LottoPrize, Integer> prizeCount, double rate) {
        validate(prizeCount);
        this.prizeCount = prizeCount;
        this.rate = rate;
    }

    private void validate(Map<LottoPrize, Integer> prizeCount) {
        //todo: 메시지 작성
        if (prizeCount == null) {
            throw new IllegalArgumentException();
        }
        if (prizeCount.get(LottoPrize.FIRST_PRIZE) == null) {
            throw new IllegalArgumentException();
        }
        if (prizeCount.get(LottoPrize.SECOND_PRIZE) == null) {
            throw new IllegalArgumentException();
        }
        if (prizeCount.get(LottoPrize.THIRD_PRIZE) == null) {
            throw new IllegalArgumentException();
        }
        if (prizeCount.get(LottoPrize.FOURTH_PRIZE) == null) {
            throw new IllegalArgumentException();
        }
        if (prizeCount.get(LottoPrize.FIFTH_PRIZE) == null) {
            throw new IllegalArgumentException();
        }
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
