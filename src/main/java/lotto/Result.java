package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Integer, Integer> statistics;

    public Result(List<Integer> profits) {
        statistics = createStatistics();
        updateStatistics(profits);
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private Map<Integer, Integer> createStatistics() {
        int initialWinCount = 0;
        Map<Integer, Integer> statistics = new LinkedHashMap<>();

        for (Ranks ranks : Ranks.values()) {
            statistics.put(ranks.getPrizeMoney(), initialWinCount);
        }
        return statistics;
    }

    private void updateStatistics(List<Integer> profits) {
        for (Integer profit : profits) {
            if (statistics.containsKey(profit)) {
                int winCount = statistics.get(profit);
                statistics.replace(profit, winCount + 1);
            }
        }
    }
}
