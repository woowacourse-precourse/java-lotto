package lotto.domain.lotto.correctLotto;

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
        return Arrays.stream(RankingValue.values())
                .filter(value -> RankingValue.findRankingValue(value, count, bonus))
                .map(Ranking::findRanking)
                .findFirst()
                .orElse(OUTOFRANKNG);
    }

    private static Ranking findRanking(RankingValue rankingValue) {
        return Arrays.stream(Ranking.values())
                .filter(value -> Ranking.isRanking(value.getRankingValue(), rankingValue))
                .findFirst()
                .orElse(OUTOFRANKNG);
    }

    private static boolean isRanking(RankingValue base, RankingValue compare) {
        return base == compare;
    };

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