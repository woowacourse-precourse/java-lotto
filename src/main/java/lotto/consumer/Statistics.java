package lotto.consumer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.machine.Ranks;

public class Statistics {
    private final static int INITIAL_COUNT = 0;

    private final Map<Integer, Integer> statistics;

    public Statistics(List<Integer> totalProfit) {
        statistics = createStatistics();
        updateStatistics(totalProfit);
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private void updateStatistics(List<Integer> totalProfit) {
        for (Integer profit : totalProfit) {
            if (statistics.containsKey(profit)) {
                int winCount = statistics.get(profit);
                statistics.replace(profit, winCount + 1);
            }
        }
    }

    private Map<Integer, Integer> createStatistics() {
        int winCount = INITIAL_COUNT;
        final Map<Integer, Integer> initialStatistics = new LinkedHashMap<>();

        for (Ranks ranks : Ranks.values()) {
            initialStatistics.put(ranks.getPrizeMoney(), winCount);
        }
        return initialStatistics;
    }
}
