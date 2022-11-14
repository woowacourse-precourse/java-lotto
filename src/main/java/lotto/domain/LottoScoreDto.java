package lotto.domain;

import java.util.Arrays;
import java.util.Map;

/**
 * 로또 출력을 위한 dto 클래스
 */
public final class LottoScoreDto {
    private static final String NULL_MESSAGE = "prizeCount 에 null 이 포함되어 있습니다";
    private final Map<LottoPrize, Integer> prizeCount;
    private final double rate;

    /**
     * 생성 시에 null 이 포함되면 IEA 예외
     *
     * @param prizeCount LottoPrize 와 그 결과가 나온 횟수를 연결한 맵
     * @param rate       수익률
     */
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

    /**
     * 5등 당첨이 몇회 있었는지에 대한 횟수를 반환한다
     *
     * @return 횟수에 해당하는 정수값
     */
    public int fifthPrizeCount() {
        return prizeCount.get(LottoPrize.FIFTH_PRIZE);
    }

    /**
     * 4등 당첨이 몇회 있었는지에 대한 횟수를 반환한다
     *
     * @return 횟수에 해당하는 정수값
     */

    public int fourthPrizeCount() {
        return prizeCount.get(LottoPrize.FOURTH_PRIZE);
    }

    /**
     * 3등 당첨이 몇회 있었는지에 대한 횟수를 반환한다
     *
     * @return 횟수에 해당하는 정수값
     */
    public int thirdPrizeCount() {
        return prizeCount.get(LottoPrize.THIRD_PRIZE);
    }

    /**
     * 2등 당첨이 몇회 있었는지에 대한 횟수를 반환한다
     *
     * @return 횟수에 해당하는 정수값
     */
    public int secondPrizeCount() {
        return prizeCount.get(LottoPrize.SECOND_PRIZE);
    }

    /**
     * 1등 당첨이 몇회 있었는지에 대한 횟수를 반환한다
     *
     * @return 횟수에 해당하는 정수값
     */
    public int firstPrizeCount() {
        return prizeCount.get(LottoPrize.FIRST_PRIZE);
    }

    /**
     * 총 수익률에 대한 퍼센트를 반환한다
     *
     * @return 퍼센트에 대한 실수값
     */
    public double getRate() {
        return rate;
    }
}
