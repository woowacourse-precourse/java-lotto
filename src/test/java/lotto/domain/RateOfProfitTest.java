package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RateOfProfitTest {
    @Test
    void profitTest() {
        CorrectNum.THREE.setCnt(4);
        CorrectNum.FOUR.setCnt(2);
        RateOfProfit.profit();
        Assertions.assertThat(RateOfProfit.profit).isEqualTo(120000D);
    }

    @Test
    void calculateTest() {
        CorrectNum.THREE.setCnt(4);
        CorrectNum.FOUR.setCnt(2);
        double calculateValue = RateOfProfit.calculate(30000);
        Assertions.assertThat(calculateValue).isEqualTo(400D);
    }
}