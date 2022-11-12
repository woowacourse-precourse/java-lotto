package lotto.consumer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.machine.Ranks;

public class Statistics {
    private final Map<Integer, Integer> statistics;

    public Statistics(List<Integer> profit) {
        statistics = createStatistics();
        updateStatistics(profit);
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
        return initialStatistics;
    }

    private void updateStatistics(List<Integer> profit) {
        for (Integer prizeMoney : profit) {
            if (statistics.containsKey(prizeMoney)) {
                int winCount = statistics.get(prizeMoney);
                statistics.replace(prizeMoney, winCount + 1);
            }
        }
    }
}
