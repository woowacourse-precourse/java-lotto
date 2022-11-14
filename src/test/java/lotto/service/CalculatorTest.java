package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    @DisplayName("Map에 저장된 당첨 금액과 당첨 횟수를 가지고 총 당첨 금액을 계산한다.")
    void totalWinningPrizeTest() {
        // given
        Map<Integer, Integer> prizes = new HashMap<>();
        for (WinningResult result : WinningResult.values()) {
            prizes.put(result.getPrize(), 2);
        }

        // when
        long totalWinningPrize = Calculator.sumWinningPrize(prizes);

        // then
        assertEquals(4_063_110_000L, totalWinningPrize);
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

    @Test
    @DisplayName("당첨 금액이 없으면 수익률은 0.0%이다.")
    void zeroYieldTest() {
        // given
        long totalWinningPrize = 0;
        int purchaseAmount = 10000;

        // when
        String yield = Calculator.getYield(totalWinningPrize, purchaseAmount);

        // then
        assertEquals("0.0%", yield);
    }

    @Test
    @DisplayName("수익률은 소수점 둘째 자리에서 반올림한다.")
    void decimalTest() {
        // given
        long totalWinningPrize = 5000;
        int purchaseAmount = 130000;

        // when
        String yield = Calculator.getYield(totalWinningPrize, purchaseAmount);

        // then
        assertEquals("3.8%", yield); // 3.84615384615...
    }
}
