package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RateCalculatorTest {
    @DisplayName("수익율 계산한다.")
    @Test
    public void CalculateReturnOfRate() {
        RateCalculator rateCalculator = new RateCalculator();
        double rateMoney = rateCalculator.calculateReturnOfRate(8000, 5000);
        assertThat(rateMoney).isEqualTo(62.5);
    }


    @DisplayName("상금 금액 합을 계산한다.")
    @Test
    void calculateWinningMoney() {
        RateCalculator rateCalculator = new RateCalculator();
        int totalMoney = rateCalculator.calculateWinningMoney(Map.of(1000, 2, 3000, 4, 5000, 6));
        assertThat(totalMoney).isEqualTo(9000);
    }
}