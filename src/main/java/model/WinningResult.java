package model;

import java.util.Map;

import static constant.Config.INIT_COUNT;

public class WinningResult {
    private final static int RATIO = 100;
    private final static double DECIMAL = 10.0;
    private final Map<Win, Integer> winningResult;

    public WinningResult(Map<Win, Integer> winningResult) {
        this.winningResult = Map.copyOf(winningResult);
    }

    public Map<Win, Integer> getWinningResult() {
        return winningResult;
    }

    public int getCount(Win win) {
        return winningResult.getOrDefault(win, INIT_COUNT);
    }

    public EarningsRate getEarningsRate(Money money) {
        double earningsRate = round(getWinningAmountSum() * RATIO / money.getMoney());
        return new EarningsRate(earningsRate);
    }

    private double round(double rate) {
        return Math.round(rate * DECIMAL) / DECIMAL;
    }

    private double getWinningAmountSum() {
        double sum = 0;
        for (Map.Entry<Win, Integer> result : winningResult.entrySet()) {
            Win win = result.getKey();
            Integer count = result.getValue();

            sum += win.getWinningAmount() * count;
        }
        return sum;
    }
}
