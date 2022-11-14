package lotto.dto;

import lotto.vo.Score;

import java.util.HashMap;
import java.util.Map;

public class ScoreInfo {
    protected final Map<Score, Integer> scoreInfo;

    public ScoreInfo() {
        HashMap<Score, Integer> scoreInfo = new HashMap<>();
        for (Score score : Score.values()) {
            scoreInfo.put(score, 0);
        }

        this.scoreInfo = scoreInfo;
    }

    public Integer get(Score score) {
        return scoreInfo.get(score);
    }

    public void addScore(Score score) {
        scoreInfo.put(score, scoreInfo.get(score) + 1);
    }
}
