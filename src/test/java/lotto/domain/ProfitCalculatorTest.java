package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorTest {

    @Test
    void testProfitIsCorrect() {
        assertEquals(ProfitCalculator.getProfit(8000, 5000), 62.5);
    }
}