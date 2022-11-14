package lotto.helper.util;

import java.util.List;
import java.util.Map;
import lotto.mvc.util.LottoRanking;

public final class TestArgumentUtils {

    private static final int RANKING_FIRST_INDEX = 0;
    private static final int RANKING_SECOND_INDEX = 1;
    private static final int RANKING_THIRD_INDEX = 2;
    private static final int RANKING_FOURTH_INDEX = 3;
    private static final int RANKING_FIFTH_INDEX = 4;

    private TestArgumentUtils() {
    }

    public static Map<LottoRanking, Integer> createArgumentMap(List<Integer> numberOfWins) {
        return Map.of(
            LottoRanking.RANKING_FIRST, numberOfWins.get(RANKING_FIRST_INDEX),
            LottoRanking.RANKING_SECOND, numberOfWins.get(RANKING_SECOND_INDEX),
            LottoRanking.RANKING_THIRD, numberOfWins.get(RANKING_THIRD_INDEX),
            LottoRanking.RANKING_FOURTH, numberOfWins.get(RANKING_FOURTH_INDEX),
            LottoRanking.RANKING_FIFTH, numberOfWins.get(RANKING_FIFTH_INDEX),
            LottoRanking.RANKING_NOTHING, 0
        );
    }
}
