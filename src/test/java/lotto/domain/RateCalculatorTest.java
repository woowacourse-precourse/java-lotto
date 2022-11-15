package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RateCalculatorTest {
    @DisplayName("수익율 계산한다.")
    @Test
    public void CalculateReturnOfRate(){
        RateCalculator rateCalculator = new RateCalculator();
        double rateMoney = rateCalculator.CalculateReturnOfRate(8000, 5000);
        assertThat(rateMoney).isEqualTo(62.5);
    }

}