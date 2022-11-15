package lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.Calculator;
import lotto.model.Generator;
import lotto.model.InputException;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void calculatePurchase() {
        final int purchaseAmount = 10000;
        final int purchaseQuantity = 10;
        final int instance = Calculator.calculatePurchase(purchaseAmount);
        assertEquals(instance, purchaseQuantity);
    }

    @Test
    void rateOfReturn() {
        final int purchaseAmount = 10000;
        final double rateOfReturn = 0;
        final double instance = Calculator.rateOfReturn(purchaseAmount);
        assertEquals(instance, rateOfReturn);
    }

    @Test
    void addPrize() {
        final double purchaseAmount = 0;
        Calculator.addPrize();
        assertEquals(purchaseAmount, 0);
    }

    @Test
    void convertNull() {
        final Integer number = null;
        final int instance = Calculator.convertNull(number);
        assertEquals(instance, 0);
    }
}