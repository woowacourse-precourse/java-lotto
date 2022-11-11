package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roi {
    private final Integer returnOnInvestment;
    private final Map<Integer, Integer> statistics;

    public Roi(Integer spending, List<Integer> profit) {
        Integer totalProfit = profit.stream()
                .mapToInt(Integer::intValue)
                .sum();
        returnOnInvestment = spending / totalProfit;
        statistics = createStatistics();
        updateStatistics(statistics, profit);
    }

    public Integer getReturnOnInvestment() {
        return returnOnInvestment;
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private Map<Integer, Integer> createStatistics() {
        List<Integer> prize = List.of(5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000);
        Map<Integer, Integer> statistics = new HashMap<>();

        for (Integer money : prize) {
            statistics.put(money, 0);
        }
        return statistics;
    }

    private void updateStatistics(Map<Integer, Integer> statistics, List<Integer> profits) {
        for (Integer profit : profits) {
            if (statistics.containsKey(profit)) {
                statistics.replace(profit, statistics.get(profit) + 1);
            }
        }
    }
}
