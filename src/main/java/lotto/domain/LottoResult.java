package lotto.domain;

import static lotto.exception.InputValidator.ERROR_MESSAGE_PREFIX;

import java.util.Arrays;

public enum LottoResult {

    ZERO(0,0),
    ONE(0,1),
    TWO(0, 2),
    THREE( 5_000, 3),
    FOUR(50_000, 4),
    FIVE(1_500_000, 5),
    FIVE_WITH_BONUS(30_000_000, 5),
    SIX(2_000_000_000, 6);

    private final int payout;
    private final int numberOfMatches;

    LottoResult(int payout, int numberOfMatches) {
        this.payout = payout;
        this.numberOfMatches = numberOfMatches;
    }

    public int getPayout() {
        return payout;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public static LottoResult of(int numberOfMatches,
                                 boolean containBonusNumber) {
        if (numberOfMatches == 5 && containBonusNumber) {
            return FIVE_WITH_BONUS;
        }

        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.hasSameNumberOfMatches(numberOfMatches))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "당첨번호 일치 갯수는 0~6개 입니다"));
    }

    private boolean hasSameNumberOfMatches(int numberOfMatches) {
        return this.numberOfMatches == numberOfMatches;
    }
}
