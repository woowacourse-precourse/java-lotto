package lotto.domain;

import lotto.enums.Rank;

import java.util.Map;

public class Result {
    private final Map<Rank, Integer> countMatch;
    private final double totalPrize;

    public Result(Map<Rank, Integer> countMatch, double totalPrize) {
        this.countMatch = countMatch;
        this.totalPrize = totalPrize;
    }

    public Map<Rank, Integer> getCountMatch() {
        return countMatch;
    }

    public double getTotalPrize() {
        return totalPrize;
    }
}
