package lotto.domain;

import lotto.vo.Lotto;
import lotto.vo.Score;
import lotto.vo.Winning;

import java.util.HashMap;
import java.util.Map;

public class ScoreInfo {
    private final Map<Score, Integer> scoreInfo;

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

    public void calculateRank(Lotto lotto, Winning winning) {
        int matchCount = getMatchCount(lotto, winning);

        if (matchCount == 6) {
            addScore(Score.FIRST);
        } else if (matchCount == 5) {
            if (isBonusMatching(lotto, winning)) {
                addScore(Score.SECOND);
                return;
            }
            addScore(Score.THIRD);
        } else if (matchCount == 4) {
            addScore(Score.FORTH);
        } else if (matchCount == 3) {
            addScore(Score.FIFTH);
        }
    }

    private boolean isBonusMatching(Lotto lotto, Winning winning) {
        return lotto.contains(winning.getBonus());
    }

    private static int getMatchCount(Lotto lotto, Winning winning) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> winning.contains(number))
                .count();
    }

    private void addScore(Score score) {
        scoreInfo.put(score, scoreInfo.get(score) + 1);
    }
}
