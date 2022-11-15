package lotto.domain;

import lotto.utils.Ranking;
import java.util.Map;

public class Prize {
    private final Map<Ranking, Integer> prize;

    public Prize(Map<Ranking, Integer> prize) {
        this.prize = prize;
    }

    public int getValue(Ranking key) {
        if (!prize.containsKey(key))
            return 0;
        return prize.get(key);
    }
}
