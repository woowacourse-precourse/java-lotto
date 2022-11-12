package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class RankGenerator {

    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(new Rank(5, 3, 5000, false));
        ranks.add(new Rank(4, 4, 50000, false));
        ranks.add(new Rank(3, 5, 1500000, false));
        ranks.add(new Rank(2, 5, 30000000, true));
        ranks.add(new Rank(1, 6, 2000000000, false));

        return ranks;
    }
}
