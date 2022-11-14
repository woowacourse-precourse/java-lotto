package lotto.domain;

import java.util.List;

public class Statistics {
    private static Rank rank;

    public Statistics(List<Rank> rankings) { // [FIFTH, NONE, SECOND, THIRD, FIFTH]
        for (Rank ranking : rankings) {
            ranking.addCount(ranking);
        }
    }
    public static Rank getRank() {
        return rank;
    }
}
