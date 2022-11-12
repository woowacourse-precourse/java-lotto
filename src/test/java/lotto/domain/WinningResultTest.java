package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {
    @Test
    void testCompareWithLotto() {
        WinningResult result = new WinningResult(List.of(1, 2, 3, 4, 5, 6), 7);
        result.checkTheResult(List.of(1, 2, 3, 12, 13, 14));
        assertEquals(result.getAccordedNum(), 3);
    }
}