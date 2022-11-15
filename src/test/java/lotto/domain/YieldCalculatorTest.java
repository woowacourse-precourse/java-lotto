package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;
import lotto.resource.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class YieldCalculatorTest {
    @DisplayName("수익률 계산 확인 테스트")
    @ParameterizedTest
    @MethodSource("generateParameter")
    void checkWinningTest(Map<String, Integer> winningCountRepository, Integer purchasePrice, BigDecimal yield) {
        YieldCalculator yieldCalculator = new YieldCalculator(winningCountRepository, purchasePrice);

        assertThat(yieldCalculator.calculate()).isEqualTo(yield);
    }

    static Stream<Arguments> generateParameter() {
        return Stream.of(
                Arguments.of(Map.of(Rank.FIFTH.name(), 1), 8000, BigDecimal.valueOf(62.5)),
                Arguments.of(Map.of(), 10000, BigDecimal.valueOf(0.0)),
                Arguments.of(Map.of(Rank.FOURTH.name(), 1), 49000, BigDecimal.valueOf(102.0))
        );
    }
}