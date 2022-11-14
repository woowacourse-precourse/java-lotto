package lotto.io;

import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateWinningNumbers("1,2,3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateWinningNumbers("1,2,3,4 ,5,6");
        });
        assertDoesNotThrow(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,6"));
    }

    @Test
    void testBonusNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
           InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "0");
           InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "-1");
           InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "46");
           InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "3");
        });
        assertDoesNotThrow(() -> InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6),"7"));
        assertDoesNotThrow(() -> InputValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6),"45"));
    }
}