package lotto.domain.lotto.correctLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Ranking {
    OUTOFRANKNG(0, 0, 0),

    FIRSTRANKING(6, 1, 2000000000),
    SECONDRANKING(6, 2, 30000000),
    THIRDRANKING(5, 3, 1500000),
    FOURTHRANKING(4, 4, 50000),
    FIFTHRANKING(3, 5, 5000),
    ;

    private int count;
    private int rankingValue;
    private long reward;

    Ranking(int count, int rankingValue, long reward) {
        this.count = count;
        this.rankingValue = rankingValue;
        this.reward = reward;
    }

    public int getRankingValue() {
        return rankingValue;
    }

    public long getReward() {
        return reward;
    }

}
