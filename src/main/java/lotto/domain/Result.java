package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<WinRank, Integer> result;

    public Result(Lottos lottos, Lotto winLotto, Integer bonusNumber) {
        this.result = new HashMap<>();
        initFinalResult();
        calculateResult(lottos, winLotto, bonusNumber);
    }

    private void calculateResult(Lottos lottos, Lotto winLotto, Integer bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            final WinRank winRank = WinRank.calculateRankOfLotto(lotto, winLotto, bonusNumber);
            updateResult(winRank);
        }
    }

    private void updateResult(WinRank winRank) {
        result.put(winRank, result.get(winRank) + 1);
    }

    private void initFinalResult() {
        WinRank.getWinnerRanks()
                .forEach(winnerRank -> result.put(winnerRank, 0));
    }
}
