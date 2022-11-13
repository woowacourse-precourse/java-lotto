package lotto.logic;

import java.util.Map;
import lotto.domain.Rank;

public class Exchanger {

    public double calculateProfitRate(Map<Rank, Integer> countOfRank, long payment) {
        long profit = calculateProfit(countOfRank);
        return (double) profit / payment;
    }

    public long calculateProfit(Map<Rank, Integer> countOfRank) {
        long profit = 0;

        for (Rank current : countOfRank.keySet()) {
            long winnings = current.getWinnings();
            int count = countOfRank.get(current);
            profit += winnings * count;
        }

        return profit;
    }

}
