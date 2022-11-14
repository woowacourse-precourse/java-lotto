package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class ScoreAndRank {

    public Map<Integer, String> scoreRank = new HashMap<>();

    public ScoreAndRank() {
        initScoreRank();
    }

    public void initScoreRank() {

        scoreRank.put(3, "fifth");
        scoreRank.put(4, "fourth");
        scoreRank.put(5, "third");
        scoreRank.put(6, "first");
        scoreRank.put(7, "second");
    }
}
