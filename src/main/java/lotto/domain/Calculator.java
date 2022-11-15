package lotto.domain;

import lotto.resources.Rank;

import java.util.List;

public class Calculator {
    private final int PERCENTAGE = 100;
    private long totalEarnings;
    private double earningsRate;
    private List<Integer> prizeMoney = List.of(Rank.NOTHING.getPrizeMoney(),
            Rank.FIRST_PLACE.getPrizeMoney(),
            Rank.SECOND_PLACE.getPrizeMoney(),
            Rank.THIRD_PLACE.getPrizeMoney(),
            Rank.FOURTH_PLACE.getPrizeMoney(),
            Rank.FIFTH_PLACE.getPrizeMoney());

    public void calculateTotalEarnings(List<Integer> result) {
        for (int i = 1; i < result.size(); i++) {
            totalEarnings += (prizeMoney.get(i) * result.get(i));
        }
    }

    public long getTotalEarnings() {
        return totalEarnings;
    }

    public void calculateEarningsRate(int purchaseAmount) {
        earningsRate = totalEarnings / (double) purchaseAmount * PERCENTAGE;
        earningsRate = Math.round(earningsRate * 10) / 10.0;    // 소숫점 둘째자리에서 반올림
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
