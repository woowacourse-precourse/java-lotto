package lotto.service;

import java.util.Arrays;
import lotto.domain.CalculatedLotto;
import lotto.ui.ConsoleMessage;

public enum LottoMatch {

    SIX_MATCHES(6, 2000000000, ConsoleMessage.SIX_MATCHES),
    FIVE_MATCHES_PLUS_BONUS(5, 30000000, ConsoleMessage.FIVE_MATCHES_PLUS_BONUS),
    FIVE_MATCHES(5, 1500000, ConsoleMessage.FIVE_MATCHES),
    FOUR_MATCHES(4, 50000, ConsoleMessage.FOUR_MATCHES),
    THREE_MATCHES(3, 5000, ConsoleMessage.THREE_MATCHES),
    NULL_RESULT(-1, 0, null);

    private final int numberMatchCount;
    private final int profit;
    private final ConsoleMessage resultMsg;

    LottoMatch(int numberMatchCount, int profit, ConsoleMessage resultMsg) {
        this.numberMatchCount = numberMatchCount;
        this.profit = profit;
        this.resultMsg = resultMsg;
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

    public ConsoleMessage getResultMsg() {
        return resultMsg;
    }
}
