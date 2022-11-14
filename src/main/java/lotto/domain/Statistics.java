package lotto.domain;

import java.util.List;

public class Statistics {
    private Rank rank;

    public Statistics(List<Rank> rankings) { // [FIFTH, NONE, SECOND, THIRD, FIFTH]
        for (Rank ranking : rankings) {
            ranking.addCount(ranking);
        }
    }

    public Rank getRank() {
        return rank;
    }
}
