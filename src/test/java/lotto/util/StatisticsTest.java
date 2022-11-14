package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    @Test
    public void compareNumberTest() throws Exception{
        //given
        List<Lotto> randomLottos = List.of(new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(7,8,9,10,11,12)),
                new Lotto(List.of(13,14,15,16,17,18)));
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
        Statistics statistics = new Statistics();
        statistics.compareNumber(randomLottos, winLotto);
        Assertions.assertEquals(statistics.getRank(),List.of(0,0,0,1,0));

    }

}