package lotto.domain;

import lotto.utils.Ranking;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;

public class Prize {
    private final HashMap<Ranking, Integer> prize;

    public Prize(HashMap<Ranking, Integer> prize) {
        this.prize = prize;
    }

    public int getValue(Ranking key) {
        if (!prize.containsKey(key))
            return 0;
        return prize.get(key);
    }
}
