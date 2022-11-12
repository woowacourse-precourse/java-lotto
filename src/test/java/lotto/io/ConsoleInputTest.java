package lotto.io;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {
    @Test
    void testGettingPurchaseAmount() {

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateToParseInt("a12");
        });
    }
}