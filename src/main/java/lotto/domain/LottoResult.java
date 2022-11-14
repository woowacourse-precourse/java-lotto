package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_COUNT = 0;
    private static final double INITIAL_RETURN_RATE = 0.0;
    private final Map<PrizeType, Integer> result = new HashMap<>();
    private double profitRate;

    public LottoResult(Lottos lottos, WinningLotto winningLotto, Money money) {
        initializeResult();
        checkResult(lottos, winningLotto);
        calculateProfitRate(money);
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
        int count = lotto.compare(winningLotto.getNumbers());
        addResult(count, lotto.isContainBonusNumber(bonusNumber));
    }

    private void addResult(int count, boolean bonus) {
        PrizeType type = PrizeType.getPrizeType(count, bonus);
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
