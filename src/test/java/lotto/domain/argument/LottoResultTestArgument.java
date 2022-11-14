package lotto.domain.argument;

import java.util.List;
import java.util.stream.Stream;
import lotto.helper.util.TestArgumentUtils;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class LottoResultTestArgument {

    private LottoResultTestArgument() {
    }

    static Stream<Arguments> lottoResultConstructorTestArgument() {
        return Stream.of(
                Arguments.of(
                        "8000", List.of(LottoRanking.RANKING_FIFTH),
                        TestArgumentUtils.createArgumentMap(List.of(0, 0, 0, 0, 1)), "62.5"),
                Arguments.of(
                        "10000",
                        List.of(LottoRanking.RANKING_FIRST, LottoRanking.RANKING_FOURTH, LottoRanking.RANKING_FIFTH),
                        TestArgumentUtils.createArgumentMap(List.of(1, 0, 0, 1, 1)), "20000550.0"));
    }
}
