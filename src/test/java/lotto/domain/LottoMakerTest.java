package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoMakerTest {
    @Test
    void testMakeExceptionGettingWrongPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoMaker.makeLotto(1101);
        });
    }

}