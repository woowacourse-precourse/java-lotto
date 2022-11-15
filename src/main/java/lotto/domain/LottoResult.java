package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final double INITIAL_RETURN_RATE = 0.0;
    private static final int FIVE_NUMBER = 5;
    private final Map<PrizeType, Integer> result = new HashMap<>();
    private double profitRate;

    public LottoResult(Lottos lottos, WinningLotto winningLotto, Money money) {
        initializeResult();
        countWinningNumber(lottos, winningLotto);
        calculateProfitRate(money);
    }

    private void initializeResult() {
        for (PrizeType type : PrizeType.values()) {
            result.put(type, INITIAL_COUNT);
        }
        profitRate = INITIAL_RETURN_RATE;
    }

    private void countWinningNumber(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            PrizeType type = findPrizeType(lotto, winningLotto.getWinningLotto(),
                    winningLotto.getBonusNumber());
            addResult(type);
        }
    }

    private PrizeType findPrizeType(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int winningCount = lotto.compare(winningLotto.getNumbers());
        if (winningCount == FIVE_NUMBER && lotto.isContainBonusNumber(bonusNumber)) {
            return PrizeType.getPrizeType(winningCount, true);
        }
        return PrizeType.getPrizeType(winningCount, false);
    }

    private void addResult(PrizeType type) {
        if (type != null) {
            result.put(type, getResult().get(type) + 1);
        }
    }

    private void calculateProfitRate(Money money) {
        long profit = sumProfit();
        if (profit != 0) {
            profitRate = (double) profit / money.getMoney() * 100;
        }
    }

    private long sumProfit() {
        long profit = 0;
        for (PrizeType type : result.keySet()) {
            profit += type.calculateProfit(result.get(type));
        }
        return profit;
    }

    public Map<PrizeType, Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}