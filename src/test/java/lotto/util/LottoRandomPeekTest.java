package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRandomPeekTest {
    @Test
    public void randomSizeTest() throws Exception{
        int count = 5;
        LottoRandomPeek test = new LottoRandomPeek();
        test.generateRandom(count);
        Assertions.assertEquals(count,test.getRandomLottos().size());
    }
}