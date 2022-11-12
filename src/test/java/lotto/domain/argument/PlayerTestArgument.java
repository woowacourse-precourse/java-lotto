package lotto.domain.argument;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.util.ranking.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class PlayerTestArgument {

    private static final int RANKING_FIRST_INDEX = 0;
    private static final int RANKING_SECOND_INDEX = 1;
    private static final int RANKING_THIRD_INDEX = 2;
    private static final int RANKING_FOURTH_INDEX = 3;
    private static final int RANKING_FIFTH_INDEX = 4;

    private PlayerTestArgument() {
    }

    static Stream<Arguments> calculateLottoGradeArgument() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_FOURTH,
                                LottoRanking.RANKING_THIRD), "3000",
                        createArgumentMap(List.of(0, 0, 1, 1, 1))),
                Arguments.of(
                        List.of(LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_FIRST,
                                LottoRanking.RANKING_THIRD,
                                LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_SECOND), "5000",
                        createArgumentMap(List.of(1, 1, 1, 0, 2))));
    }

    private static Map<LottoRanking, Integer> createArgumentMap(List<Integer> numberOfWins) {
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
