package lotto.domain.argument;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.helper.util.TestArgumentUtils;
import lotto.util.ranking.LottoRanking;
import org.junit.jupiter.params.provider.Arguments;

public final class CalculateRevenueArgument {

    private CalculateRevenueArgument() {
    }

    private static final int RANKING_FIRST_INDEX = 0;
    private static final int RANKING_SECOND_INDEX = 1;
    private static final int RANKING_THIRD_INDEX = 2;
    private static final int RANKING_FOURTH_INDEX = 3;
    private static final int RANKING_FIFTH_INDEX = 4;

    static Stream<Arguments> calculateRevenuePercentArgument() {
        return Stream.of(
                Arguments.of(
                        TestArgumentUtils.createArgumentMap(List.of(0, 0, 0, 0, 1)), "8000", "62.5"),
                Arguments.of(
                        TestArgumentUtils.createArgumentMap(List.of(1, 0, 0, 1, 1)), "10000", "20000550.0"),
                Arguments.of(
                        TestArgumentUtils.createArgumentMap(List.of(1, 1, 1, 1, 1)), "500000", "406311.0")
        );
    }
}
