package model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static constant.Config.INIT_COUNT;

public class WinningResult {
    private final static int RATIO = 100;
    private final static double DECIMAL = 10.0;
    private final Map<Win, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new EnumMap<>(Win.class);

        for (Win win : Win.values()) {
            this.winningResult.put(win, INIT_COUNT);
        }
    }

    public Map<Win, Integer> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }

    public int getCount(Win win) {
        return winningResult.getOrDefault(win, INIT_COUNT);
    }

    public void putWinningResult(Win win) {
        int count = winningResult.getOrDefault(win, INIT_COUNT);
        winningResult.put(win, ++count);
    }

    public void sumWinningResult(WinningResult result) {
        Map<Win, Integer> winningResult = result.getWinningResult();
        winningResult.forEach((win, count) -> this.winningResult.merge(win, count, Integer::sum));
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
