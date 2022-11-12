package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoMakerTest {
    @Test
    void testMakeExceptionGettingWrongPrice() {
        LottoMaker.makeLotto(1101);
    }

}