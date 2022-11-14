package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("로또 구매 금액에 가지고 발행해야 할 로또 개수를 계산한다.")
    void purchaseCountTest() {
        // given
        int purchaseAmount = 10000;

        // when
        int purchaseCount = Calculator.getPurchaseCount(purchaseAmount);

        // then
        assertEquals(10, purchaseCount);
    }

    @Test
    @DisplayName("총 당첨 금액과 로또 구매 금액을 가지고 수익률을 계산한다.")
    void yieldTest() {
        // given
        long totalWinningPrize = 5000;
        int purchaseAmount = 8000;

        // when
        String yield = Calculator.getYield(totalWinningPrize, purchaseAmount);

        // then
        assertEquals("62.5%", yield);
    }
}
