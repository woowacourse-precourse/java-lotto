package lotto.model;

import java.util.Map;
import lotto.util.LottoCalculator;

public class LottoResult {

    private final Map<LottoRank, Integer> winCount;
    private final double yield;

    public LottoResult(Lottos lottos, WinningNumber winningNumber) {
        this.winCount = LottoCalculator.calculateWinCount(lottos, winningNumber);
        this.yield = LottoCalculator.calculateYield(winCount, lottos.getPurchaseAmount());
    }

    public Map<LottoRank, Integer> getWinCount() {
        return winCount;
    }

    public double getYield() {
        return yield;
    }

}
