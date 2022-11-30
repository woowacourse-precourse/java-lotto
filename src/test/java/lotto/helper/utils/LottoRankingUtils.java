package lotto.helper.utils;

import java.util.List;
import java.util.Map;
import lotto.domain.game.LottoRanking;

public class LottoRankingUtils {

    private static final int RANKING_FIRST_INDEX = 0;
    private static final int RANKING_SECOND_INDEX = 1;
    private static final int RANKING_THIRD_INDEX = 2;
    private static final int RANKING_FOURTH_INDEX = 3;
    private static final int RANKING_FIFTH_INDEX = 4;

    private LottoRankingUtils() {
    }

    public static Map<LottoRanking, Integer> createArgumentMap(List<Integer> numberOfWins) {
        return Map.of(
                LottoRanking.FIRST, numberOfWins.get(RANKING_FIRST_INDEX),
                LottoRanking.SECOND, numberOfWins.get(RANKING_SECOND_INDEX),
                LottoRanking.THIRD, numberOfWins.get(RANKING_THIRD_INDEX),
                LottoRanking.FOURTH, numberOfWins.get(RANKING_FOURTH_INDEX),
                LottoRanking.FIFTH, numberOfWins.get(RANKING_FIFTH_INDEX),
                LottoRanking.NOTHING, 0
        );
    }
}
