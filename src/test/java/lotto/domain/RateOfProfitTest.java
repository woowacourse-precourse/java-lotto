package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class RateOfProfitTest {
    @BeforeEach
    @AfterEach
    void setUp() {
        CorrectNum[] values = CorrectNum.values();
        for (CorrectNum value : values) {
            value.setCnt(0);
        }
        RateOfProfit.profit = 0;
    }
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