package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoMakerTest {
    @Test
    void testMakeExceptionGettingWrongPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoMaker.makeLotto(1101);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            LottoMaker.makeLotto(0);
        });
    }

    @Test
    void testReturnNumOfLottoAsExpected() {
        assertEquals(13, LottoMaker.makeLotto(13000).size());
        assertEquals(1, LottoMaker.makeLotto(1000).size());
    }

}