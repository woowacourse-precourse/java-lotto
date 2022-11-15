package lotto.model;

import java.util.*;

public class ScoreAndRank {

    private Map<Integer, String> scoreRank = new LinkedHashMap<>();

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

    public Map<Integer, String> getScoreRank() {
        return this.scoreRank;
    }
}
