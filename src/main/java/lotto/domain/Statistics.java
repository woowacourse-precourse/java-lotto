package lotto.domain;

import java.util.Map;

public class Statistics {
    private Map<Prize, Integer> prizeMap;

    public Statistics(Map<Prize, Integer> prizeMap) {
        this.prizeMap = prizeMap;
    }

    public Map<Prize, Integer> getPrizeMap() {
        return prizeMap;
    }
}
