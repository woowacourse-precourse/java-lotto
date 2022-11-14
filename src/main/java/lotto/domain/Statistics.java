package lotto.domain;

import java.util.Map;

public class Statistics {

    private final Map<Integer, Integer> ranking;
    private final double yield;

    public Statistics(Map<Integer, Integer> ranking, double yield) {
        this.ranking = ranking;
        this.yield = yield;
    }

    public Map<Integer, Integer> getRanking() {
        return ranking;
    }

    public double getYield() {
        return yield;
    }
}
