package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatYieldNumberTest {

    @DisplayName("수익률 포멧 테스트")
    @Test
    void yieldFormatTest() {
        String formatYield = FormatYieldNumber.get(12345);
        assertAll(
                () -> assertEquals("12,345.0", formatYield),
                () -> assertNotEquals("12,345", formatYield),
                () -> assertNotEquals("12345", formatYield)
        );
    }
}