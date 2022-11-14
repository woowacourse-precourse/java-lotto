package lotto.consumer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.machine.Ranks;
import lotto.util.Calculator;

public class Statistics {
    private final Map<Integer, Integer> statistics;

    public Statistics(Profit profit) {
        statistics = createStatisticsBy(profit.getProfit());
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private Map<Integer, Integer> createStatisticsBy(List<Integer> profit) {
        int initialWinCount = 0;
        Map<Integer, Integer> initialStatistics = new LinkedHashMap<>();
        for (Ranks ranks : Ranks.values()) {
            initialStatistics.put(ranks.getPrizeMoney(), initialWinCount);
        }

        Calculator.updateStatistics(initialStatistics, profit);
        return initialStatistics;
    }
}
