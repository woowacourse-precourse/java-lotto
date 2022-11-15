package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void hasNumber1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertTrue(lotto.hasNumber(1));
    }

    @Test
    void hasNumber2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertFalse(lotto.hasNumber(0));
    }

    @Test
    void testToString() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(lotto.toString(), "[1, 2, 3, 4, 5, 6]");
    }
}
