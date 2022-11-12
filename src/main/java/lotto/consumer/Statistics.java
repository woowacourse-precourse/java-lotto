package lotto.consumer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.machine.Ranks;
import lotto.util.Calculator;

public class Statistics {
    private final Map<Integer, Integer> statistics;
    private final List<Integer> profit;

    public Statistics(Profit profit) {
        this.profit = profit.getProfit();
        statistics = createStatistics();
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private Map<Integer, Integer> createStatistics() {
        int initialWinCount = 0;
        Map<Integer, Integer> initialStatistics = new LinkedHashMap<>();
        for (Ranks ranks : Ranks.values()) {
            initialStatistics.put(ranks.getPrizeMoney(), initialWinCount);
        }

        Calculator.updateStatistics(initialStatistics, profit);
        return initialStatistics;
    }
}
