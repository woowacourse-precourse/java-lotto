package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {
    List<Integer> statistics = new ArrayList<>();

    public Statistics(List<Rank> rankings) { // [FIFTH, NONE, SECOND, THIRD, FIFTH]
        for(Rank rank: Rank.values()) {
            statistics.add(Collections.frequency(rankings, rank));
        }
    }

    public List<Integer> getStatistics() {
        return statistics;
    }
}
