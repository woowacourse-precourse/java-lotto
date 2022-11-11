package lotto.domain;

import java.util.Arrays;
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
    private int numberOfMatches;


    LottoResult(int payout, int matchingNumberCount) {
        this.payout = payout;
        this.numberOfMatches = matchingNumberCount;
    }

    public int getPayout() {
        return payout;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public static LottoResult of(Lotto lotto,
                                 List<Integer> winningNumbers,
                                 int bonusNumber) {
        long matchingNumberCount = lotto.compareWinningNumbers(winningNumbers);

        if (matchingNumberCount == 5 && lotto.isContainBonusNumber(bonusNumber)) {
            return FIVE_WITH_BONUS;
        }

        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getNumberOfMatches() == matchingNumberCount)
                .findFirst()
                .get();
    }
}
