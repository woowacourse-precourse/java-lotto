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

    private static final Integer SECOND_RANKING_COUNT = 6;
    private static final Integer POINT = 1;
    private static final Integer INITIAL_VALUE = 0;
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

    public static Ranking makeRanking(int count, boolean bonus) {
        if (count < SECOND_RANKING_COUNT) {
            return Arrays.stream(Ranking.values())
                    .filter(ranking -> ranking.count == count)
                    .findFirst()
                    .orElse(OUTOFRANKNG);
        }

        if (count == SECOND_RANKING_COUNT && bonus == true) {
            return Ranking.SECONDRANKING;
        }

        return Ranking.FIRSTRANKING;
    }

    public static Map<Ranking, Integer> makeRankingCount(Rankings rankings) {
        Map<Ranking, Integer> rankingCount = new HashMap<>();
        for (Ranking ranking : Ranking.values()) {
            rankingCount.put(ranking, INITIAL_VALUE);
        }

        for (Ranking ranking : rankings.getRankings()) {
            rankingCount.merge(ranking, POINT, (v1, v2) -> v1 + POINT);
        }
        return rankingCount;
    }

}