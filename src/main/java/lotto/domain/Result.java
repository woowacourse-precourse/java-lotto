package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<WinRank, Integer> result;

    public Result(Lottos lottos, Lotto winLotto, BonusNumber bonusNumber) {
        this.result = new HashMap<>();
        initialize();
        calculate(lottos, winLotto, bonusNumber);
    }

    public Map<WinRank, Integer> get() {
        return Collections.unmodifiableMap(result);
    }

    private void calculate(Lottos lottos, Lotto winLotto, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            final WinRank winRank = WinRank.calculateOfLotto(lotto, winLotto, bonusNumber);
            updateResult(winRank);
        }
    }

    private void updateResult(WinRank winRank) {
        result.put(winRank, result.get(winRank) + 1);
    }

    private void initialize() {
        WinRank.getWinnerRanks()
                .forEach(winnerRank -> result.put(winnerRank, 0));
    }

    private Integer getTotalPrize() {
        Integer totalPrize = 0;
        for (WinRank winRank : result.keySet()) {
            totalPrize += winRank.getPrize() * result.get(winRank);
        }
        return totalPrize;
    }

    public Float getEarningRate(Integer inputMoney) {
        final float earningRate = (float) getTotalPrize() / inputMoney;
        return (float) (Math.round(earningRate * 1000) / 10.0);
    }
}
