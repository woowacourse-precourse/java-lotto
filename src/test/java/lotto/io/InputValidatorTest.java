package lotto.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void testGettingPurchaseAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateToParseInt("a12");
        });
    }

    @Test
    void testWinningNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateWinningNumbers("1,a,3");
        });
    }
}