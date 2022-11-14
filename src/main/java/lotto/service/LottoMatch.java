package lotto.service;

import java.util.Arrays;
import lotto.domain.CalculatedLotto;

public enum LottoMatch {

    SIX_MATCHES(6, 2000000000),
    FIVE_MATCHES_PLUS_BONUS(5, 30000000),
    FIVE_MATCHES(5, 1500000),
    FOUR_MATCHES(4, 50000),
    THREE_MATCHES(3, 5000),
    NULL_RESULT(-1, 0);

    private final int numberMatchCount;
    private final int profit;

    LottoMatch(int numberMatchCount, int profit) {
        this.numberMatchCount = numberMatchCount;
        this.profit = profit;
    }

    public static LottoMatch calculatedLottoMapper(CalculatedLotto calculatedLotto) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matches(calculatedLotto))
                .findAny()
                .orElse(NULL_RESULT);
    }

    public boolean matches(CalculatedLotto calculatedLotto) {
        if (calculatedLotto.getWinningLottoCount() == 5 && numberMatchCount == 5 && calculatedLotto
                .isBonusNumberIncluded()) {
            return true;
        }
        if (calculatedLotto.getWinningLottoCount() == numberMatchCount) {
            return true;
        }
        return false;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public int getProfit() {
        return profit;
    }

}
