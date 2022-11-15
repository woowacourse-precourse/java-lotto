package lotto.domain.argument;

import java.util.List;
import java.util.stream.Stream;
import lotto.helper.util.TestArgumentUtils;
import org.junit.jupiter.params.provider.Arguments;

public final class CalculateRevenueArgument {

    private CalculateRevenueArgument() {
    }

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
