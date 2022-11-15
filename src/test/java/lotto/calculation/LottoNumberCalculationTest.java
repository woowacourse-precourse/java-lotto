package lotto.calculation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberCalculationTest {

    @Test
    void LottoNumberCalculationTest() {
        int purchaseCount = 2;
        for (int i = 0; i<5000; i++) {
            assertThat(LottoNumberCalculation.putTicket(purchaseCount)).hasSize(2);
            assertThat(LottoNumberCalculation.putTicket(purchaseCount).get(0)).hasSize(6);
            assertThat(LottoNumberCalculation.putTicket(purchaseCount).get(0)).isInstanceOf(List.class);
            assertThat(LottoNumberCalculation.putTicket(purchaseCount).get(0).get(0)).isInstanceOf(Integer.class);
            assertThat(LottoNumberCalculation.putTicket(purchaseCount).get(0).get(0)).isBetween(1,45);
        }//for
    }// LottoNumberCalculationTest
} // end class
