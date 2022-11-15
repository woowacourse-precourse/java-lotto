package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateCalculatorTest {

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @CsvSource(value = {"THREE, 62.5", "SIX, 25_000_000", "LESS_THAN_THREE, 0"})
    void calculateEarningRate(CorrectNumber correctNumber, float expectedRate) {
        int inputMoney = 8_000;
        assertThat(EarningRateCalculator.calculateEarningRate(correctNumber, inputMoney))
                .isEqualTo(expectedRate);
    }
}
