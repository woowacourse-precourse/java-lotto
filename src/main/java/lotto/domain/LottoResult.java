package lotto.domain;

import lotto.view.OutputView;

import java.util.*;

public class LottoResult {
    private Map<Rank, Integer> result = new HashMap<>();

    public void getResult(WinningLotto winningLotto, Lottos purchaseLotto) {
        for (Iterator<Lotto> it = purchaseLotto.iterator(); it.hasNext(); ) {
            Lotto lotto = it.next();
            Rank rank = winningLotto.oneCompare(lotto);
            if (result.containsKey(rank)) {
                result.put(rank, result.get(rank) + 1);
                continue;
            }
            result.put(rank, 1);
        }
    }

    public void printResult() {
        OutputView.printLottoResult(result);
    }
}
