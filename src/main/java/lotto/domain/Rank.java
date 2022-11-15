package lotto.domain;

import java.util.LinkedHashMap;

public class Rank {
    private final LinkedHashMap<Integer, Integer> ranking;

    public Rank(LinkedHashMap<Integer, Integer> ranking) {
        this.ranking = ranking;
    }

    public LinkedHashMap<Integer, Integer> getRank() {
        return ranking;
    }
}
