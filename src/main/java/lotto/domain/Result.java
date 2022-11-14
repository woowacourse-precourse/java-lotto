package lotto.domain;

import java.util.LinkedHashMap;

public class Result {
    private static LinkedHashMap<Rank, Integer> initResult() {
        LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
