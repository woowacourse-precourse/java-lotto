package lotto.model;

import java.util.*;

public class ScoreBoard {

    private Map<String, Integer> rankAndScore = new LinkedHashMap<>();

    public ScoreBoard() {
        initScoreBoard();
    }

    public void initScoreBoard() {
        List<Rank> Ranks = new ArrayList<>(List.of(Rank.values()));

        for (Rank rank : Ranks) {
            rankAndScore.put(rank.name(), 0);
        }
    }

    public void plusScore(String rank) {
        this.rankAndScore.replace(rank, this.rankAndScore.get(rank) + 1);
    }

    public Map<String, Integer> getRankAndScore() {
        return this.rankAndScore;
    }

}
