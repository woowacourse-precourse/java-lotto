package lotto.domain.statistics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class YieldRateTest {

    @ParameterizedTest
    @CsvSource({"8000, 5000, 62.5", "10000, 1235, 12.4"})
    void 정상_계산_테스트(int calcAmount, long amountSum, String expected) {
        YieldRate yieldRate = new YieldRate(calcAmount, amountSum);

        assertThat(yieldRate.toString()).isEqualTo(expected);
    }

    @Test
    void 쉼표_테스트() {
        정상_계산_테스트(100000, 1234567L, "1,234.6");
    }
}