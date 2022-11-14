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

    public Map<Prize, Integer> getStatisticsResult() {
        return statisticsResult;
    }

}