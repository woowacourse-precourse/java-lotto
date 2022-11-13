package lotto.domain.argument;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.util.ranking.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class LottoResultTestArgument {

    private static final int RANKING_FIRST_INDEX = 0;
    private static final int RANKING_SECOND_INDEX = 1;
    private static final int RANKING_THIRD_INDEX = 2;
    private static final int RANKING_FOURTH_INDEX = 3;
    private static final int RANKING_FIFTH_INDEX = 4;

    private LottoResultTestArgument() {
    }

    static Stream<Arguments> lottoResultConstructorTestArgument() {
        return Stream.of(
                Arguments.of(
                        "8000", List.of(LottoRanking.RANKING_FIFTH),
                        createArgumentMap(List.of(0, 0, 0, 0, 1)), "62.5"),
                Arguments.of(
                        "10000",
                        List.of(LottoRanking.RANKING_FIRST, LottoRanking.RANKING_FOURTH, LottoRanking.RANKING_FIFTH),
                        createArgumentMap(List.of(1, 0, 0, 1, 1)), "20000550.0"));
    }

    static Map<LottoRanking, Integer> createArgumentMap(List<Integer> numberOfWins) {
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
