package lotto.model;

import java.util.*;

public class ScoreBoard {
    public final static int INIT_SCORE = 0;

    private final Map<String, Integer> rankAndScore = new LinkedHashMap<>();

    public ScoreBoard() {
        initScoreBoard();
    }

    public void initScoreBoard() {
        List<Rank> Ranks = new ArrayList<>(List.of(Rank.values()));

        for (Rank rank : Ranks) {
            rankAndScore.put(rank.name(), INIT_SCORE);
        }
    }

    public void plusScore(String rank) {
        this.rankAndScore.replace(rank, this.rankAndScore.get(rank) + 1);
    }

    public Map<String, Integer> getRankAndScore() {
        return this.rankAndScore;
    }
}
