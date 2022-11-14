package lotto.domain;

import lotto.utils.Ranking;

import java.util.HashMap;

public class Prize {
    private final HashMap<Ranking, Integer> prize;

    public Prize(HashMap<Ranking, Integer> prize) {
        this.prize = prize;
    }
}
