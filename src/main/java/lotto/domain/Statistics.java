package lotto.domain;

import java.util.Map;

public class Statistics {
    private Map<Prize, Integer> prizeMap;
    private double total;

    public Statistics(Map<Prize, Integer> prizeMap) {
        this.prizeMap = prizeMap;
        this.total = calculateTotal();
    }

    private Double calculateTotal() {
        double sum = 0;
        for (Prize prize : prizeMap.keySet()) {
            sum += prize.getMoney() * prizeMap.get(prize);
        }
        return sum;
    }

    public Map<Prize, Integer> getPrizeMap() {
        return prizeMap;
    }

    public double getTotal() {
        return total;
    }
}
