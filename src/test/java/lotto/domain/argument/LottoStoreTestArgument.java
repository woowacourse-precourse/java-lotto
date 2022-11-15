package lotto.domain.argument;

import java.util.List;
import java.util.stream.Stream;
import lotto.helper.util.TestArgumentUtils;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class LottoStoreTestArgument {

    private LottoStoreTestArgument() {
    }

    static Stream<Arguments> calculateLottoResultArgument() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_FOURTH,
                                LottoRanking.RANKING_THIRD), "3000",
                        TestArgumentUtils.createArgumentMap(List.of(0, 0, 1, 1, 1))),
                Arguments.of(
                    List.of(LottoRanking.RANKING_FIFTH,
                                LottoRanking.RANKING_FIRST,
                                LottoRanking.RANKING_THIRD,
                                LottoRanking.RANKING_SECOND), "4000",
                    TestArgumentUtils.createArgumentMap(List.of(1, 1, 1, 0, 1))));
    }
}
