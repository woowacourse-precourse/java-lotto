package lotto;

import lotto.domain.LottoRandomPeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoRandomPeekTest {
    @Test
    public void randomDrawTest() throws Exception{
        LottoRandomPeek test = new LottoRandomPeek(1);
        test.drawLotto();
    }
    @Test
    public void randomSizeTest() throws Exception{
        int count = 5;
        LottoRandomPeek test = new LottoRandomPeek(count);
        Assertions.assertEquals(count,test.getRandomLottos().size());
    }
}