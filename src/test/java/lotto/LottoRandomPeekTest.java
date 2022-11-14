package lotto;

import lotto.domain.Lotto;
import lotto.util.LottoRandomPeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoRandomPeekTest {
    @Test
    public void randomDrawTest() throws Exception{
        LottoRandomPeek test = new LottoRandomPeek();
        test.addLotto(List.of(1,2,3,4,5,6));
        test.addLotto(List.of(7,8,9,10,11,12));
        test.addLotto(List.of(13,14,15,16,17,18));
        List<List<Integer>> lists = List.of(List.of(1, 2, 3, 4, 5,6), List.of(7,8,9,10,11,12),List.of(13,14,15,16,17,18));
        int count =0;
        for(Lotto tmp : test.getRandomLottos()){
            Assertions.assertEquals(tmp.getNumbers(), lists.get(count++));
        }
    }
    @Test
    public void randomSizeTest() throws Exception{
        int count = 5;
        LottoRandomPeek test = new LottoRandomPeek();
        test.generateRandom(count);
        Assertions.assertEquals(count,test.getRandomLottos().size());
    }
}