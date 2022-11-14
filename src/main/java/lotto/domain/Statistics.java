package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<Prize, Integer> statisticsResult;

    public Statistics() {
        statisticsResult = new HashMap<>();
        init();
    }

    private void init() {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NOTHING) {
                continue;
            }
            statisticsResult.put(prize, 0);
        }
    }

    public void updateStatistics(Prize prize) {
        if(prize == Prize.NOTHING) {
            return;
        }
        statisticsResult.merge(prize, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public Map<Prize, Integer> getStatisticsResult() {
        return statisticsResult;
    }

}