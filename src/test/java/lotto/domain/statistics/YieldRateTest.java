package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class YieldRateTest {

    @ParameterizedTest
    @CsvSource({"8000, 5000, 62.5", "10000, 1235, 12.35"})
    void 정상_계산_테스트(int calcAmount, long amountSum, double expected) {
        YieldRate yieldRate = new YieldRate(calcAmount, amountSum);

        assertThat(yieldRate.rate()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10000, 10000, 100.0%"})
    void 문자열_테스트(int calcAmount, long amountSum, String expected) {
        YieldRate yieldRate = new YieldRate(calcAmount, amountSum);

        assertThat(yieldRate.toString()).isEqualTo(expected);
    }

    @Test
    void 쉼표_문자열_테스트() {
        문자열_테스트(1000, 1234567, "123,456.7%");
    }
}