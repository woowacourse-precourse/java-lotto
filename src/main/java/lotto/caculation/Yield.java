package lotto.caculation;

import lotto.utils.WinningType;

import java.util.LinkedHashMap;
import java.util.Map;


public class Yield {
    private Map<WinningType, Integer> yield;

    public Yield(Map<WinningType, Integer> winningResult) {
        yield = new LinkedHashMap<>();
        for (WinningType winningType : WinningType.values()) {
            yield.put(winningType, 0);
        }
        yield.putAll(winningResult);
    }

    public Map<WinningType, Integer> getYield() {
        return yield;
    }

    public double getYieldOfLotto(Money money) {
        return Math.floor(getEarning() / money.getMoney() * 100) / 100;
    }

    private int getEarning() {
        int sum = 0;
        for (Map.Entry<WinningType, Integer> entry : yield.entrySet()) {
            sum += entry.getKey().getWinningAmount() * entry.getValue();
        }
        return sum;
    }
}
