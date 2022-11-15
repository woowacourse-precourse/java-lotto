package lotto.domain;

import java.util.Map;

public class ReturnRatioCalculator {
    private int totalPrizeMoney = 0;

    public double calculateReturnRatio(double expenses, Map<Rank, Integer> winningStatus ) {
        calculateTotalPrizeMoney(winningStatus);
        return (totalPrizeMoney / expenses) * 100;
    }

    private int calculateTotalPrizeMoney(Map<Rank, Integer> winningStatus) {

        for (Rank rank : winningStatus.keySet()) {

            Integer numberOfTimesWonInThisRank = winningStatus.get(rank);

            for (int count = 0; count < numberOfTimesWonInThisRank; count++) {
                totalPrizeMoney += Rank.getRankPrize(rank);
            }
        }

        return totalPrizeMoney;
    }

}
