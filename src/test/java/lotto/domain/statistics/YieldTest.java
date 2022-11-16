package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.statistics.Yield;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YieldTest {

    @ParameterizedTest
    @CsvSource({
        "8000, 5000, 62.5",
        "10000, 2000000000, 20000000.0",
        "5000, 50000, 1000.0",
        "7000, 50000, 714.2857142857143",
    })
    void 수익률_생성_테스트(int money, long prize, double expected) {
        Yield yield = Yield.of(money, prize);
        assertThat(yield.getYield())
            .isEqualTo(expected);
    }
}