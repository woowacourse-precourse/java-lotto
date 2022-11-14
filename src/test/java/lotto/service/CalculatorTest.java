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
}
