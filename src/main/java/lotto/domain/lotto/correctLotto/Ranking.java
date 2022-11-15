package lotto.domain.lotto.correctLotto;

import org.mockito.internal.matchers.Null;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Ranking {
    OUTOFRANKNG(RankingValue.OUT, 0),
    FIRSTRANKING(RankingValue.FIRST, 2000000000),
    SECONDRANKING(RankingValue.SECOND, 30000000),
    THIRDRANKING(RankingValue.THIRD, 1500000),
    FOURTHRANKING(RankingValue.FOURTH, 50000),
    FIFTHRANKING(RankingValue.FIFTH, 5000),
    ;

    private static final Integer SECOND_RANKING_COUNT = 6;
    private static final Integer POINT = 1;
    private static final Integer INITIAL_VALUE = 0;

    private final RankingValue rankingValue;
    private final long reward;

    Ranking(RankingValue rankingValue, long reward) {
        this.rankingValue = rankingValue;
        this.reward = reward;
    }

    public RankingValue getRankingValue() {
        return rankingValue;
    }

    public long getReward() {
        return reward;
    }

    public static Ranking makeRanking(int count, boolean bonus) {
        if (count < SECOND_RANKING_COUNT) {
            return Arrays.stream(Ranking.values())
                    .filter(ranking -> ranking.rankingValue.getCount() == count)
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