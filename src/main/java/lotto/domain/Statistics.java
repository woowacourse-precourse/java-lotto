package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private static final int DEFAULT_STATISTIC_VALUE = 0;
    private static final int INCREASING_VALUE = 1;
    private static final int REVENUE_INITIAL_VALUE = 0;
    private static final int REVENUE_RATIO_VALUE = 100;
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
            statisticsResult.put(prize, DEFAULT_STATISTIC_VALUE);
        }
    }

    public void updateStatistics(Prize prize) {
        if (prize == Prize.NOTHING) {
            return;
        }
        statisticsResult.merge(prize, INCREASING_VALUE, (oldValue, newValue) -> oldValue + INCREASING_VALUE);
    }

    public float calculateYiled(Amount amount) {
        float revenue = REVENUE_INITIAL_VALUE;
        for (Prize prize : statisticsResult.keySet()) {
            if (statisticsResult.get(prize) > DEFAULT_STATISTIC_VALUE) {
                revenue += prize.getReward() * statisticsResult.get(prize);
            }
        }
        return (revenue / amount.getValue()) * REVENUE_RATIO_VALUE;
    }

    public Map<Prize, Integer> getStatisticsResult() {
        return statisticsResult;
    }

}