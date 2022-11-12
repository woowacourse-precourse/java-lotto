package lotto.mock;

import lotto.domain.ScoreInfo;
import lotto.vo.Score;

public class MockScoreInfo extends ScoreInfo {
    public void setMockScore(Score score, int value) {
        scoreInfo.put(score, value);
    }
}
