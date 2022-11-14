package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<PrizeType, Integer> result = new HashMap<>();
    private int returnRate;

    public LottoResult(Lottos purchasedLottos, WinningLotto winningLotto, Money money) {

    }

    private int countWinningNumber() {

    }
}
