package lotto.domain.yield;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

class YieldTest {

    @ParameterizedTest(name = "{0}원이 {1}원이 되었을 때 수익률은 {2}% 이다.")
    @CsvSource({
            "8000, 5000, 62.5",
            "8000, 8000, 100",
            "8000, 16000, 200",
            "3000, 10000, 333.33",
            "3000, 9500, 316.67",
    })
    void calculateYieldTest(final int principal, final int totalReward, final double percent) {
        // when
        Yield yield = Yield.calculate(principal, totalReward);

        // then
        assertThat(yield.getPercent())
                        .isCloseTo(percent, offset(0.01));
    }
}