package lotto.domain;

import java.util.List;

public enum LottoResult {

    ZERO(0,0),
    ONE(0,1),
    TWO(0, 2),
    THREE( 5_000, 3),
    FOUR(50_000, 4),
    FIVE(1_500_000, 5),
    FIVE_WITH_BONUS(30_000_000, 5),
    SIX(2_000_000_000, 6);

    private int payout;
    private int matchingNumberCount;


    LottoResult(int payout, int matchingNumberCount) {
        this.payout = payout;
        this.matchingNumberCount = matchingNumberCount;
    }

    public int getPayout() {
        return payout;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public static LottoResult of(Lotto lotto,
                                 List<Integer> winningNumbers,
                                 int bonusNumber) {
        long matchingNumberCount = lotto.compareWinningNumbers(winningNumbers);


        if (matchingNumberCount == 0) {
            return ZERO;
        }

        if (matchingNumberCount == 1) {
            return ONE;
        }

        if (matchingNumberCount == 2) {
            return TWO;
        }

        if (matchingNumberCount == 3) {
            return THREE;
        }

        if (matchingNumberCount == 4) {
            return FOUR;
        }

        if (matchingNumberCount == 5) {
            if (lotto.isContainBonusNumber(bonusNumber)) {
                return FIVE_WITH_BONUS;
            }
            return FIVE;
        }
        return SIX;
    }
}
