package lotto.model;

import java.util.Map;
import java.util.Set;

public class Statistics {
    private static final String COUNT_STATE = " - %d개";

    private Map<Rank, Integer> winningLottoCounter;

    public Statistics(RankCount rankCount) {
        this.winningLottoCounter = rankCount.countRank();
    }

    public int computeTotalPrice() {
        Set<Rank> ranks = winningLottoCounter.keySet();
        int totalPrice = 0;

        for (Rank rank : ranks) {
            int price = rank.computePrice(winningLottoCounter.get(rank));
            totalPrice += price;
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();
        Set<Rank> ranks = winningLottoCounter.keySet();
        for (Rank rank : ranks) {
            statistics.append(rank.toString() + getCountString(winningLottoCounter.get(rank)));
            statistics.append("\n");
        }
        statistics.delete(statistics.lastIndexOf("\n"), statistics.length());
        return statistics.toString();
    }

    private String getCountString(int count) {
        return String.format(COUNT_STATE, count);
    }
}
