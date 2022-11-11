package lotto.domain;

import java.util.List;

public class Calculator {
    private int totalEarnings;
    private double earningsRate;
    private List<Integer> prizeMoney = List.of(0, 2000000000, 30000000, 1500000, 50000, 5000);

    private void calculateTotalEarnings(List<Integer> result) {
        for (int i = 1; i < result.size(); i++) {
            totalEarnings += (prizeMoney.get(i) * result.get(i));
        }
    }
    public int getTotalEarnings() {
        return totalEarnings;
    }
    private void calculateEarningsRate(int purchaseAmount) {
        earningsRate = (double) totalEarnings / purchaseAmount * 100;
        earningsRate = Math.round(earningsRate * 10) / 10.0;
    }
    public double getEarningsRate() {
        return earningsRate;
    }
}
