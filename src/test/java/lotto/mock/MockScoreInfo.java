package lotto.mock;

import lotto.dto.ScoreInfo;
import lotto.vo.Score;

public class MockScoreInfo extends ScoreInfo {
    public void setMockScore(Score score, int value) {
        scoreInfo.put(score, value);
    }
}
