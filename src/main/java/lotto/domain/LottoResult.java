package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final double INITIAL_RETURN_RATE = 0.0;
    private Map<PrizeType, Integer> result = new HashMap<>();
    private double profitRate;

    public LottoResult(Lottos lottos, WinningLotto winningLotto, Money money) {
        initializeResult();
        checkResult(lottos, winningLotto);
        // TODO : calculateProfitRate(money);
    }

    private void initializeResult() {
        for (PrizeType type : PrizeType.values()) {
            result.put(type, INITIAL_COUNT);
        }
        profitRate = INITIAL_RETURN_RATE;
    }

    private void checkResult(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            countWinningNumber(lotto, winningLotto.getWinningLotto(),
                    winningLotto.getBonusNumber());
        }
    }

    private void countWinningNumber(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int count = 0;
        for (int number : winningLotto.getNumbers()) {
            if (lotto.isContainNumber(number)) {
                count += 1;
            }
        }
        if (lotto.isContainNumber(bonusNumber)) {
            addResult(count, true);
        }
        addResult(count, false);
    }

    private void addResult(int count, boolean isBonus) {
        PrizeType type = PrizeType.getPrizeType(count, isBonus);
        if (type != null) {
            result.put(type, count);
        }
    }
}
