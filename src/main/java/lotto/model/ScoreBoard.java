package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {

    public Map<String, Integer> rankAndScore = new HashMap<>();

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
        rankAndScore.replace(rank, rankAndScore.get(rank) + 1);
    }

}
